package teambuilder.team.application.Command;

import shared.core.domain.Command.Command;
import teambuilder.team.infrastructure.controller.TeamController;

final public class CreateTeamCommand implements Command {

    private final TeamController receiver;

    private CreateTeamCommand(TeamController receiver) {
        this.receiver = receiver;
    }

    public static CreateTeamCommand of(TeamController receiver) {
        return new CreateTeamCommand(receiver);
    }

    public void execute(String... args) {
        receiver.createTeamAction();
    }
}
