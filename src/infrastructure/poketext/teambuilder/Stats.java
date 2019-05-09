package infrastructure.poketext.teambuilder;

import application.nature.GetNatures.GetNaturesService;
import domain.pokemon.BaseStats;
import infrastructure.persistence.SQLite.NatureRepositorySQLite;
import infrastructure.persistence.SQLite.PokemonRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.service.ReaderService;
import infrastructure.presentation.transformer.matrix.NatureAssemblerMatrix;

import infrastructure.poketext.calc.Estadistiques;
import java.io.IOException;
import java.util.Arrays;

public class Stats {

    private final static int MAX_EVS = 508;

    private static String selectNature() throws IOException {
        String s;
        int selected;

        GetNaturesService service = new GetNaturesService(new NatureRepositorySQLite(), new NatureAssemblerMatrix());
        String[][] natures = service.execute();

        String[] options = new String[natures.length];
        for (int i = 0; i < natures.length; i++) {
            options[i] = natures[i][0];
        }

        MatrixPrinter.print(natures);
        System.out.printf("%n");

        do {

            s = ReaderService.read();
            selected = Arrays.asList(options).indexOf(s);

            if (selected < 1) {
                System.out.println("Selecció incorrecte");
            }
        } while (selected < 1);

        return natures[selected][0];
    }

    private static int calcularEVsRestants(String[] evs) {
        int suma = 0;

        for (String ev : evs) {
            suma += Integer.parseInt(ev);
        }

        return MAX_EVS - suma;
    }

    // Mostar per pantalla els stats
    private static void imprimirStats(String[][] poke) {
        int i, j;
        String[] noms = {"HP", "Attack", "Defense", "Sp. Atk.", "Sp. Def.", "Speed"};

        PokemonRepositorySQLite pokemonRepository = new PokemonRepositorySQLite();
        NatureRepositorySQLite natureRepository = new NatureRepositorySQLite();
        BaseStats stats = pokemonRepository.findStatsByPokemonId(Integer.parseInt(poke[0][0]));

        int[] base = {
            stats.getHealth(),
            stats.getAttack(),
            stats.getDefense(),
            stats.getSpecialAttack(),
            stats.getSpecialDefense(),
            stats.getSpeed()
        };

        System.out.printf("%n%s%n", "Nom: " + poke[0][1]);
        for (i = 0; i < 37; i++) {
            System.out.print("*");
        }
        System.out.printf("%n*%15s%5s%5s%8s  *", "Base", "EVs", "IVs", "Stats");
        for (i = 0; i < 6; i++) {
            System.out.printf("%n* ");
            for (j = 0; j < 33; j++) {
                System.out.print("-");
            }
            System.out.printf(" *%n*%10s%5d%5s%5s  |%5s  *", noms[i], base[i], poke[4][i], poke[5][i], poke[3][i]);
        }
        System.out.printf("%n* ");
        for (j = 0; j < 33; j++) {
            System.out.print("-");
        }

        System.out.printf(" *%n*   EVs restants:%4s%16s%n*", calcularEVsRestants(poke[4]), "*");
        for (i = 0; i < 35; i++) {
            System.out.print("*");
        }
        System.out.printf("*%nNaturalesa: %s%n", natureRepository.getNameById(poke[4][6]));
    }

    static void escollirStats(String[][] poke) throws IOException {
        boolean sortir = false;
        String[] s;

        do {
            Estadistiques.calcularEstadistiques(poke);
            imprimirStats(poke);

            // Opcions del menú
            System.out.printf("%nPOKETEXT: EDITOR DE ESTADÍSTIQUES%n");
            System.out.println("E. Editar EVs (0-252)");
            System.out.println("I. Editar IVs (0-31)");
            System.out.println("N. Seleccionar una naturalesa");
            System.out.println("F. Finalitzar la edició");
            s = ReaderService.read().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("e")) && (s.length == 3)) {
                if ((Integer.parseInt(s[2]) >= 0) && (Integer.parseInt(s[2]) <= 252)) {
                    if ((poke[0][0].equals("292")) && (s[1].equals("0"))) {
                        System.out.println("Shedinja no pot canviar els seus HP");
                    } else {
                        poke[4][Integer.parseInt(s[1])] = s[2];
                        if (calcularEVsRestants(poke[4]) < 0) {
                            poke[4][Integer.parseInt(s[1])] = "0";
                            System.out.println("No queden prous EVs");
                        }
                    }
                } else {
                    System.out.println("No pots posar la quantitat d'EVs seleccionada");
                }
            } else if ((s[0].equalsIgnoreCase("i")) && (s.length == 3)) {
                if ((Integer.parseInt(s[2]) >= 0) && (Integer.parseInt(s[2]) <= 31)) {
                    poke[5][Integer.parseInt(s[1])] = s[2];
                } else {
                    System.out.println("No pots posar la quantitat d'IVs seleccionada");
                }
            } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 1)) {
                poke[4][6] = selectNature();
            } else if ((s[0].equalsIgnoreCase("f")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
