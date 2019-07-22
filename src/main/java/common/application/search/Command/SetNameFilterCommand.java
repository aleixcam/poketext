package common.application.search.Command;

import common.application.search.Searcher;
import common.domain.Command.Command;

final public class SetNameFilterCommand implements Command {

    private final Searcher receiver;

    private SetNameFilterCommand(Searcher receiver) {
        this.receiver = receiver;
    }

    public static SetNameFilterCommand of(Searcher receiver) {
        return new SetNameFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setNameFilter(args[0]);
    }
}
