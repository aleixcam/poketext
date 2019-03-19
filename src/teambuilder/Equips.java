package teambuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import infrastructure.presentation.reader.StreamReader;
import infrastructure.persistence.CSV.CSVRepository;
import infrastructure.persistence.CSV.Fitxers;

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
    protected static String[][] iniciarPokemon() {
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

    // Exportar un equip
    private static void exportarEquip(String[][][] equip) throws IOException {
        List<String[]> list = new ArrayList<>();
        for (String[][] poke : equip) {
            if (poke != null) {
                list.add(CSVRepository.write(poke, ","));
            }
        }
        String[][] raw = new String[list.size()][];
        for (int i = 0; i < raw.length; i++) {
            raw[i] = list.get(i);
        }
        Fitxers.escriureFitxer(CSVRepository.write(raw, ";"), Fitxers.obtenirURL("equips"));
    }

    // Crear un nou equip
    private static void crearEquip(String[][][] equip) throws IOException {
        boolean sortir = false;
        int num;
        String s[];

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
                        equip[num] = CSVRepository.read(Fitxers.llegirFitxer(Fitxers.obtenirURL("pokemons")), ",");
                    } else {
                        System.out.println("No pots escollir més Pokèmons");
                    }
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (equip[Integer.parseInt(s[1]) - 1] != null) {
                        Fitxers.escriureFitxer(CSVRepository.write(equip[Integer.parseInt(s[1]) - 1], ","), Fitxers.obtenirURL("pokemons"));
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

    // Importar un equip
    public static String[][][] importarEquip() throws IOException, FileNotFoundException {
        String[][][] equip = new String[6][][];
        String[][] raw = CSVRepository.read(Fitxers.llegirFitxer(Fitxers.obtenirURL("equips")), ";");
        for (int i = 0; i < raw.length; i++) {
            equip[i] = CSVRepository.read(raw[i], ",");
        }
        return equip;
    }

    // Començar a construïr un equip
    public static void construirEquip() throws IOException {
        boolean sortir = false;
        String sel;
        do {
            try {

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
                    Fitxers.eliminarFitxer(Fitxers.obtenirURL("equips"));
                } else if (sel.equalsIgnoreCase("p")) {
                    Fitxers.eliminarFitxer(Fitxers.obtenirURL("pokemons"));
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
