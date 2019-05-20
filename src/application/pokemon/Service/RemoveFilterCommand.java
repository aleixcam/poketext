package application.pokemon.Service;

import application.command.Command;

public class RemoveFilterCommand implements Command {

    private final SearchPokemonsService service;
    private final String filter;

    public RemoveFilterCommand(SearchPokemonsService service, String filter) {
        this.service = service;
        this.filter = filter;
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
