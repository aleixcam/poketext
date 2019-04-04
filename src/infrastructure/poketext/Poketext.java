package infrastructure.poketext;

import combat.Jugadors;
import cercador.Cercador;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import infrastructure.presentation.reader.StreamReader;
import teambuilder.Equips;

// Clase principal
public class Poketext {

    final public static Properties env = new Properties();
    
    public static void main(String[] args) throws IOException {
        boolean sortir = false;
        String sel;

        System.out.println("Carregant...");

        env.loadFromXML(new FileInputStream(".env.xml"));
        Connector.connectar();

        do {

            // Menú principal
            System.out.printf("%nPOKETEXT: MENÚ PRINCIPAL%n");
            System.out.println("1. Jugar");
            System.out.println("2. Construir un Equip");
            System.out.println("3. Cercador");
            System.out.println("4. Proves");
            System.out.println("Q. Sortir");
            sel = StreamReader.read();

            // Seleccions del menú principal
            if (sel.equals("1")) {
                Jugadors.iniciarCombat();
            } else if (sel.equals("2")) {
                Equips.construirEquip();
            } else if (sel.equals("3")) {
                Cercador.cercadorPrincipal();
            } else if (sel.equals("4")) {
                System.out.println("Proves");
            } else if (sel.equalsIgnoreCase("q")) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
        System.out.println("Adéu!");
        Connector.tancar();
    }
}
