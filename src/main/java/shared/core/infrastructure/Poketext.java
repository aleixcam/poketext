package shared.core.infrastructure;

import shared.core.legacy.Connector;
import shared.core.infrastructure.Controller.AppController;
import shared.core.domain.Command.Menu;

public class Poketext {

    public static void main(String... args) {
        System.out.println("Carregant...");

        Connector.connectar();

        AppController receiver = new AppController();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", receiver::showdown, "Jugar");
        menu.register("2", receiver::teamBuilder, "Construir un Equip");
        menu.register("3", receiver::indexer, "Cercador");

        menu.execute();

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
