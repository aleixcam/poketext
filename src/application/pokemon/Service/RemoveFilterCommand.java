package application.pokemon.Service;

import application.command.Command;

public class RemoveFilterCommand implements Command {

    private final SearchPokemonsService service;

    private String filter;

    public RemoveFilterCommand(SearchPokemonsService service) {
        this.service = service;
    }

    public void execute() {
        switch (filter) {
            case "n":
                service.removeNameFilter();
                break;
            case "t":
                service.removeTypeFilter();
                break;
            default:
                System.out.print("Filter not found");
        }
    }
}
