package pokemon.application.Command;

import common.application.Command.Command;
import pokemon.infrastructure.controller.PokemonController;

final public class SetNameFilterCommand implements Command {

    private final PokemonController receiver;

    private SetNameFilterCommand(PokemonController receiver) {
        this.receiver = receiver;
    }

    public static SetNameFilterCommand of(PokemonController receiver) {
        return new SetNameFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setNameFilter(args[0]);
    }
}
