package infrastructure.poketext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import infrastructure.presentation.controller.BaseController;
import infrastructure.presentation.reader.StreamReader;
import infrastructure.service.Menu;

public class Poketext {

    final public static Properties env = new Properties();
    
    public static void main(String[] args) throws IOException {
        String selection;

        System.out.println("Carregant...");

        env.loadFromXML(new FileInputStream(".env.xml"));
        Connector.connectar();

        BaseController controller = new BaseController();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", "Jugar", controller::play);
        menu.register("2", "Construir un Equip", controller::teambuilder);
        menu.register("3", "Cercador", controller::pokedex);

        do {
            menu.print();
            selection = StreamReader.read().toUpperCase();

            menu.execute(selection);
        } while (!selection.equals(menu.EXIT));

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
