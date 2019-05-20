package application.pokemon.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

final public class RemoveFilterCommand implements Command {

    private final SearchPokemonsService receiver;

    private RemoveFilterCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public static RemoveFilterCommand of(SearchPokemonsService receiver) {
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
