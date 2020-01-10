package teambuilder.team.application.Command;

import shared.core.domain.Command.Command;
import shared.core.infrastructure.Controller.AppController;

final public class TeamBuilderCommand implements Command {

    private final AppController receiver;

    private TeamBuilderCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static TeamBuilderCommand of(AppController receiver) {
        return new TeamBuilderCommand(receiver);
    }

    public void execute(String... args) {
        receiver.teamBuilder();
    }
}
