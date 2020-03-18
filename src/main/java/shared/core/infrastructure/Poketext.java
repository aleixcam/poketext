package shared.core.infrastructure;

import shared.core.legacy.Connector;
import showndown.player.application.Command.ShowdownCommand;
import indexer.pokedex.application.Command.IndexerCommand;
import teambuilder.team.application.Command.TeamBuilderCommand;
import shared.core.infrastructure.Controller.AppController;
import shared.core.domain.Command.Menu;

public class Poketext {

    public static void main(String... args) {
        System.out.println("Carregant...");

        Connector.connectar();

        AppController receiver = new AppController();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", ShowdownCommand.of(receiver), "Jugar");
        menu.register("2", TeamBuilderCommand.of(receiver), "Construir un Equip");
        menu.register("3", IndexerCommand.of(receiver), "Cercador");

        menu.execute();

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
