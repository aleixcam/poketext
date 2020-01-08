package shared.searcher.application.Command;

import shared.searcher.application.Searcher;
import shared.core.domain.Command.Command;

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
