package application;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class Menu implements MenuInvoker {

    public final String EXIT = "Q";

    private final String title;
    private final HashMap<String, Pair<Command, String>> actions = new HashMap<>();

    public Menu(String title) {
        this.title = title;
    }

    public void register(String selector, Command action, String option) {
        actions.put(selector, Pair.of(action, option));
    }

    public void execute(String selector) {
        Command action = actions.get(selector).getLeft();

        if (action == null) {
            if (!selector.equals(EXIT)) {
                System.out.println("Invalid selection");
            }

            return;
        }

        action.execute();
    }

    public void print() {
        System.out.printf("%n%s%n", title);

        for(Map.Entry<String, Pair<Command, String>> entry : actions.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue().getRight());
        }

        System.out.printf("%s. Sortir%n", EXIT);
    }
}
