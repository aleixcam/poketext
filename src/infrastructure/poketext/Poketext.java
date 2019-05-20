package infrastructure.poketext;

import application.player.Command.StartBattleCommand;
import application.pokedex.Command.StartPokedexCommand;
import application.team.Command.TeamBuilderCommand;
import infrastructure.presentation.controller.AppController;
import infrastructure.service.ReaderService;
import application.command.Menu;

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
            selection = ReaderService.read().toUpperCase();

            menu.execute(selection);
        } while (!selection.equals(menu.EXIT));

        System.out.println("Adéu!");
        Connector.tancar();
    }
}
