package showdown.player.legacy;

import shared.core.infrastructure.Service.ReaderService;
import teambuilder.party.domain.Team;
import teambuilder.pokemon.legacy.Pokes;

public class Jugadors {

    // Comprovar que tots els jugadors tinguin un equip seleccionat
    private static boolean comprovarJugadors(String[][][][] jugador) {
        for (String[][][] equip : jugador) {
            if (equip == null) {
                return false;
            }
        }

        return true;
    }

    // Cambiar les opcions del showndown.legacy.combat
    private static int opcionsCombat() {
        int mode = 0;
        String sel;

        do {

            // Opcions del menú
            System.out.printf("%nPOKETEXT: MODE DE JOC%n");
            System.out.println("1. Combat Individual");
            sel = ReaderService.read();

            // Seleccions del menú principal
            if (sel.equals("1")) {
                mode = Integer.parseInt(sel);
                System.out.println("Mode de joc canviat a Individual");
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (mode != 0);
        return mode;
    }

    // Iniciar el showndown.legacy.combat
    public static void iniciarCombat() {
        boolean sortir = false;
        int mode = 1;
        String[][][][] jugador = new String[2][][][];
        String[] s;

        do {

            // Opcions del menú
            System.out.printf("%nPOKETEXT: INICIAR COMBAT%n");
            System.out.println("S. Seleccionar equip (#J)");
            System.out.println("V. Veure equip (#J)");
            System.out.println("M. Mode de joc");
            System.out.println("A. Acceptar");
            System.out.println("Q. Sortir al menú principal");
            s = ReaderService.read().split(" ");

            // Seleccions del menú principal
            if ((s[0].equalsIgnoreCase("s")) && (s.length == 2)) {
                jugador[Integer.parseInt(s[1]) - 1] = Team.retrieve();
            } else if ((s[0].equalsIgnoreCase("v")) && (s.length == 2)) {
                if (jugador[Integer.parseInt(s[1]) - 1] != null) {
                    for (String[][] poke : jugador[Integer.parseInt(s[1]) - 1]) {
                        if (poke != null) {
                            Pokes.imprimirPoke(poke);
                        }
                    }
                } else {
                    System.out.println("No has escollit cap equip");
                }
            } else if ((s[0].equalsIgnoreCase("m")) && (s.length == 1)) {
                mode = opcionsCombat();
            } else if ((s[0].equalsIgnoreCase("a")) && (s.length == 1)) {
                if (comprovarJugadors(jugador)) {
                    System.out.println("Acceptar");
                    sortir = true;
                } else {
                    System.out.println("Els jugadors no estàn preparats");
                }
            } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
