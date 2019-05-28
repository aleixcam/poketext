package application.team.Command;

import application.command.Command;
import infrastructure.presentation.controller.AppController;

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
