package application.pokemon.Command;

import application.command.Command;
import infrastructure.presentation.controller.PokemonController;

final public class RemoveFilterCommand implements Command {

    private final PokemonController receiver;

    private RemoveFilterCommand(PokemonController receiver) {
        this.receiver = receiver;
    }

    public static RemoveFilterCommand of(PokemonController receiver) {
        return new RemoveFilterCommand(receiver);
    }

    public void execute(String... args) {
        switch (args[0]) {
            case "n":
                receiver.removeNameFilter();
                break;
            case "t":
                receiver.removeTypeFilter();
                break;
            default:
                System.out.print("Filter not found");
        }
    }
}
