package teambuilder.party.application.Command;

import shared.core.domain.Command.Command;
import teambuilder.party.infrastructure.Controller.TeamController;

final public class RemoveTeamCommand implements Command {

    private final TeamController receiver;

    private RemoveTeamCommand(TeamController receiver) {
        this.receiver = receiver;
    }

    public static RemoveTeamCommand of(TeamController receiver) {
        return new RemoveTeamCommand(receiver);
    }

    public void execute(String... args) {
        receiver.removeTeamAction();
    }
}
