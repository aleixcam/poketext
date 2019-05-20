package application.ability.Command;

import application.command.Command;
import infrastructure.presentation.controller.PokedexController;

final public class SearchAbilitiesCommand implements Command {

    private final PokedexController receiver;

    private SearchAbilitiesCommand(PokedexController receiver) {
        this.receiver = receiver;
    }

    public static SearchAbilitiesCommand of(PokedexController receiver) {
        return new SearchAbilitiesCommand(receiver);
    }

    public void execute(String... args) {
        receiver.abilities();
    }
}
