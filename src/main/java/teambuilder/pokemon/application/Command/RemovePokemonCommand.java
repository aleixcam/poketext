package teambuilder.pokemon.application.Command;

import shared.core.domain.Command.Command;
import teambuilder.team.infrastructure.Controller.TeamController;

final public class RemovePokemonCommand implements Command {

    private final TeamController receiver;

    private RemovePokemonCommand(TeamController receiver) {
        this.receiver = receiver;
    }

    public static RemovePokemonCommand of(TeamController receiver) {
        return new RemovePokemonCommand(receiver);
    }

    public void execute(String... args) {
        receiver.removePokemonAction();
    }
}
