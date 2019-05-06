package infrastructure.poketext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import application.AppReceiver;
import infrastructure.service.ReaderService;
import application.Menu;

public class Poketext {

    final public static Properties env = new Properties();
    
    public static void main(String[] args) throws IOException {
        String selection;

        System.out.println("Carregant...");

        env.loadFromXML(new FileInputStream(".env.xml"));
        Connector.connectar();

        AppReceiver receiver = new AppReceiver();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", receiver::play, "Jugar");
        menu.register("2", receiver::teambuilder, "Construir un Equip");
        menu.register("3", receiver::pokedex, "Cercador");

        do {
            menu.print();
            selection = ReaderService.read().toUpperCase();

            menu.execute(selection);
        } while (!selection.equals(menu.EXIT));

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
