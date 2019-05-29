package pokemon.application.Command;

import common.application.Command.Command;
import pokemon.infrastructure.controller.PokemonController;

final public class SetTypeFilterCommand implements Command {

    private final PokemonController receiver;

    private SetTypeFilterCommand(PokemonController receiver) {
        this.receiver = receiver;
    }

    public static SetTypeFilterCommand of(PokemonController receiver) {
        return new SetTypeFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setTypeFilter(args[0]);
    }
}
