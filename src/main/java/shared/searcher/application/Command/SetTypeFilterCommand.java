package shared.searcher.application.Command;

import shared.searcher.application.Searcher;
import shared.core.domain.Command.Command;

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
