package teambuilder;

import java.io.FileNotFoundException;
import java.io.IOException;

import infrastructure.persistence.FileSystem.PokemonRepositoryFileSystem;
import infrastructure.persistence.FileSystem.TeamRepositoryFileSystem;
import infrastructure.presentation.reader.StreamReader;

public class Equips {

    // Comprovar si l'equip és vàid
    private static boolean equipValid(String[][][] equip) {
        boolean correcte = true;
        for (int i = 0; i < equip.length && correcte; i++) {
            if (equip[i] != null) {
                for (int j = 0; j < equip[i][2].length && correcte; j++) {
                    if (equip[i][2][j].equals("")) {
                        correcte = false;
                    }
                }
            }
        }
        return correcte;
    }

    // Comprovar si l'equip és vàid
    private static int seguentPokemon(String[][][] equip) {
        int n = 6;
        for (int i = 5; i > -1; i--) {
            if (equip[i] == null) {
                n = i;
            }
        }
        return n;
    }

    // Iniciar l'array d'equip
    private static String[][] iniciarPokemon() {
        String[][] poke = {
            new String[4],
            new String[6],
            new String[4],
            new String[6],
            new String[7],
            new String[6]
        };

        for (int i = 0; i < poke.length; i++) {
            for (int j = 0; j < poke[i].length; j++) {
                poke[i][j] = "";
            }
        }

        for (int i = 0; i < 6; i++) {
            poke[4][i] = "0";
            poke[5][i] = "31";
        }

        poke[1][0] = "100";
        poke[1][2] = "255";
        poke[1][3] = "false";
        poke[4][6] = "25";

        return poke;
    }

    private static String[][] importarPokemon() {
        PokemonRepositoryFileSystem pokemonRepository = new PokemonRepositoryFileSystem();
        String[] pokemons = pokemonRepository.listDirectory(pokemonRepository.DIRECTORY);
        System.out.println("Saved pokemons:");
        for (String pokemon : pokemons) {
            System.out.println(pokemon);
        }

        return pokemonRepository.get(StreamReader.read());
    }

    private static void exportarPokemon(String[][] pokemon) {
        PokemonRepositoryFileSystem pokemonRepository = new PokemonRepositoryFileSystem();
        pokemonRepository.save(pokemon, StreamReader.read());
    }

    public static String[][][] importarEquip() {
        TeamRepositoryFileSystem teamRepository = new TeamRepositoryFileSystem();
        String[] pokemons = teamRepository.listDirectory(teamRepository.DIRECTORY);
        System.out.println("Saved teams:");
        for (String pokemon : pokemons) {
            System.out.println(pokemon);
        }

        return teamRepository.get(StreamReader.read());
    }

    private static void exportarEquip(String[][][] equip) {
        TeamRepositoryFileSystem teamRepository = new TeamRepositoryFileSystem();
        teamRepository.save(equip, StreamReader.read());
    }

    // Crear un nou equip
    private static void crearEquip(String[][][] equip) throws IOException {
        boolean sortir = false;
        int num;
        String[] s;

        do {
            try {

                // Opcions del menú
                System.out.printf("%nPOKETEXT: CONSTRUCTOR D'EQUIPS%n");
                System.out.println("S. Escollir un nou Pokèmon");
                System.out.println("M. Editar un Pokèmon (1-6)");
                System.out.println("D. Eliminar un Pokèmon (1-6)");
                System.out.println("V. Veure els Pokèmons");
                System.out.println("I. Importar Pokèmon");
                System.out.println("E. Exportar Pokèmon (1-6)");
                System.out.println("F. Finalitzar i guardar l'equip");
                System.out.println("Q. Cancelar i sortir");
                s = StreamReader.read().split(" ");

                // Seleccions del menú principal
                if ((s[0].equalsIgnoreCase("s")) && (s.length == 1)) {
                    if ((num = seguentPokemon(equip)) < 6) {
                        equip[num] = Pokes.escollirPoke(iniciarPokemon());
                    } else {
                        System.out.println("No pots escollir més Pokèmons");
                    }
                } else if ((s[0].equalsIgnoreCase("m")) && (s.length == 2)) {
                    if (equip[Integer.parseInt(s[1]) - 1] != null) {
                        Pokes.editarPoke(equip[Integer.parseInt(s[1]) - 1]);
                    } else {
                        System.out.println("No hi ha cap Pokèmon");
                    }
                } else if ((s[0].equalsIgnoreCase("d")) && (s.length == 2)) {
                    System.out.println("Eliminant Pokèmon...");
                    equip[Integer.parseInt(s[1]) - 1] = null;
                } else if ((s[0].equalsIgnoreCase("v")) && (s.length == 1)) {
                    for (String[][] poke : equip) {
                        if (poke != null) {
                            Pokes.imprimirPoke(poke);
                        }
                    }
                } else if ((s[0].equalsIgnoreCase("i")) && (s.length == 1)) {
                    if ((num = seguentPokemon(equip)) < 6) {
                        equip[num] = importarPokemon();
                    } else {
                        System.out.println("No pots escollir més Pokèmons");
                    }
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (equip[Integer.parseInt(s[1]) - 1] != null) {
                        exportarPokemon(equip[Integer.parseInt(s[1]) - 1]);
                    } else {
                        System.out.println("No hi ha cap Pokèmon");
                    }
                } else if ((s[0].equalsIgnoreCase("f")) && (s.length == 1)) {
                    if (equipValid(equip)) {
                        exportarEquip(equip);
                        sortir = true;
                    } else {
                        System.out.println("L'equip no és valid i no es pot guardar");
                    }
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.err.println("Paràmetres incorrectes");
            } catch (FileNotFoundException ex) {
                System.err.println("Fitxer no trobat");
            }
        } while (!sortir);
    }

    // Començar a construïr un equip
    public static void construirEquip() throws IOException {
        boolean sortir = false;
        String sel;
        do {
            try {

                TeamRepositoryFileSystem teamRepository = new TeamRepositoryFileSystem();
                PokemonRepositoryFileSystem pokemonRepository = new PokemonRepositoryFileSystem();

                // Opcions del menú
                System.out.printf("%nPOKETEXT: CONSTRUCTOR D'EQUIPS%n");
                System.out.println("C. Crear un nou equip");
                System.out.println("M. Modificar un equip");
                System.out.println("E. Eliminar un equip");
                System.out.println("P. Eliminar un Pokèmon");
                System.out.println("Q. Sortir al menú principal");
                sel = StreamReader.read();

                // Seleccions del menú principal
                if (sel.equalsIgnoreCase("c")) {
                    crearEquip(new String[6][][]);
                } else if (sel.equalsIgnoreCase("m")) {
                    crearEquip(importarEquip());
                } else if (sel.equalsIgnoreCase("e")) {
                    teamRepository.delete(StreamReader.read());
                } else if (sel.equalsIgnoreCase("p")) {
                    pokemonRepository.delete(StreamReader.read());
                } else if (sel.equalsIgnoreCase("q")) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } catch (FileNotFoundException ex) {
                System.err.println("Fitxer no trobat");
            }
        } while (!sortir);
    }
}
