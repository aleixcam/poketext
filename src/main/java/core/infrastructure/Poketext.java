package core.infrastructure;

import shared.legacy.Connector;
import showndown.player.application.Command.ShowdownCommand;
import indexer.pokedex.application.Command.StartPokedexCommand;
import teambuilder.team.application.Command.TeamBuilderCommand;
import core.infrastructure.controller.AppController;
import shared.domain.Command.Menu;

public class Poketext {

    public static void main(String... args) {
        System.out.println("Carregant...");

        Connector.connectar();

        AppController receiver = new AppController();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", ShowdownCommand.of(receiver), "Jugar");
        menu.register("2", TeamBuilderCommand.of(receiver), "Construir un Equip");
        menu.register("3", StartPokedexCommand.of(receiver), "Cercador");

        menu.execute();

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
