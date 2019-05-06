package infrastructure.poketext;

import application.AppReceiver;
import infrastructure.service.ReaderService;
import application.Menu;

public class Poketext {

    public static void main(String[] args) {
        String selection;

        System.out.println("Carregant...");

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
