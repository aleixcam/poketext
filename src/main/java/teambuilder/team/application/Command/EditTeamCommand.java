package teambuilder.team.application.Command;

import shared.core.domain.Command.Command;
import teambuilder.team.infrastructure.Controller.TeamController;

final public class EditTeamCommand implements Command {

    private final TeamController receiver;

    private EditTeamCommand(TeamController receiver) {
        this.receiver = receiver;
    }

    public static EditTeamCommand of(TeamController receiver) {
        return new EditTeamCommand(receiver);
    }

    public void execute(String... args) {
        receiver.editTeamAction();
    }
}
