package cercador;

import java.io.IOException;
import utils.Comuna;

public class Cercador {

    // Clase principal del cercador
    public static void cercadorPrincipal() throws IOException {
        String filtre = null;
        boolean sortir = false;
        String sel;

        do {

            // Mostrar per pantalla la cerca
            if (filtre != null) {
                System.err.println("EN CONSTRUCCIÓ");
            }

            // Menú principal
            System.out.printf("%nPOKÈTEXT: CERCADOR%n");
            System.out.println("C. Cercador estàndard");
            System.out.println("P. Cerca Pokèmons");
            System.out.println("M. Cerca Moviments");
            System.out.println("O. Cerca Objectes");
            System.out.println("A. Cerca Habilitats");
            System.out.println("Q. Sortir");
            sel = Comuna.obtenirText();

            // Seleccions del menú principal
            if (sel.equals("c")) {
                System.out.print("Introdueix l'element que vols cecar: ");
                filtre = Comuna.in.readLine();
            } else if (sel.equals("p")) {
                Pokedex.cercarPokemons();
                filtre = null;
            } else if (sel.equals("m")) {
                Moves.cercarMoves();
                filtre = null;
            } else if (sel.equals("o")) {
                Objectes.cercarObjectes();
                filtre = null;
            } else if (sel.equals("a")) {
                Habilitats.cercarHabilitats();
                filtre = null;
            } else if (sel.equalsIgnoreCase("q")) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
