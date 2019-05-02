package infrastructure.poketext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import infrastructure.presentation.controller.BaseController;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.service.MenuService;

public class Poketext {

    final public static Properties env = new Properties();
    
    public static void main(String[] args) throws IOException {
        String sel;

        System.out.println("Carregant...");

        env.loadFromXML(new FileInputStream(".env.xml"));
        Connector.connectar();

        BaseController controller = new BaseController();
        MenuService menu = new MenuService();

        do {

            // Menú principal
            System.out.printf("%nPOKETEXT: MENÚ PRINCIPAL%n");
            System.out.println("1. Jugar");
            System.out.println("2. Construir un Equip");
            System.out.println("3. Cercador");
            System.out.println("4. Proves");
            System.out.println("Q. Sortir");
            sel = StreamReader.read();

            if (sel.equalsIgnoreCase("q")) {
                break;
            }

            menu.register("1", controller::play);
            menu.register("2", controller::teambuilder);
            menu.register("3", controller::pokedex);

            menu.execute(sel.toUpperCase());
        } while (true);

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
