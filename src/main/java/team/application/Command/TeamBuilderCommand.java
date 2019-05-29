package team.application.Command;

import common.application.Command.Command;
import poketext.infrastructure.controller.AppController;

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
