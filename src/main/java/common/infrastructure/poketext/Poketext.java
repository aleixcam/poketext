package common.infrastructure.poketext;

import player.application.Command.StartBattleCommand;
import pokedex.application.Command.StartPokedexCommand;
import team.application.Command.TeamBuilderCommand;
import common.infrastructure.controller.AppController;
import common.infrastructure.service.ReaderService;
import common.application.Command.Menu;

public class Poketext {

    public static void main(String[] args) {
        String selection;

        System.out.println("Carregant...");

        Connector.connectar();

        AppController receiver = new AppController();

        Menu menu = new Menu("POKETEXT: MENÚ PRINCIPAL");
        menu.register("1", StartBattleCommand.of(receiver), "Jugar");
        menu.register("2", TeamBuilderCommand.of(receiver), "Construir un Equip");
        menu.register("3", StartPokedexCommand.of(receiver), "Cercador");

        do {
            menu.print();
            selection = ReaderService.read();

            menu.execute(selection);
        } while (!menu.isExit(selection));

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
