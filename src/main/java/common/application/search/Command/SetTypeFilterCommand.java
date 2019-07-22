package common.application.search.Command;

import common.application.search.Searcher;
import common.domain.Command.Command;

final public class SetTypeFilterCommand implements Command {

    private final Searcher receiver;

    private SetTypeFilterCommand(Searcher receiver) {
        this.receiver = receiver;
    }

    public static SetTypeFilterCommand of(Searcher receiver) {
        return new SetTypeFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setTypeFilter(args[0]);
    }
}
