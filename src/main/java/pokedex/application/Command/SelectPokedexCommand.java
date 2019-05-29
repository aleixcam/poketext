package pokedex.application.Command;

import common.application.Command.Command;
import pokemon.infrastructure.controller.PokemonController;

final public class SelectPokedexCommand implements Command {

    private final PokemonController receiver;

    private SelectPokedexCommand(PokemonController receiver) {
        this.receiver = receiver;
    }

    public static SelectPokedexCommand of(PokemonController receiver) {
        return new SelectPokedexCommand(receiver);
    }

    public void execute(String... args) {
        receiver.selectPokedex();
    }
}
