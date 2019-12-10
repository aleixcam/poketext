package teambuilder.team.application.Command;

import shared.domain.Command.Command;
import teambuilder.team.infrastructure.controller.TeamController;

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
