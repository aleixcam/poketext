package teambuilder.team.application.Command;

import shared.domain.Command.Command;
import core.infrastructure.controller.AppController;

final public class TeamBuilderCommand implements Command {

    private final AppController receiver;

    private TeamBuilderCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static TeamBuilderCommand of(AppController receiver) {
        return new TeamBuilderCommand(receiver);
    }

    public void execute(String... args) {
        receiver.teambuilder();
    }
}
