package infrastructure.service;

import java.util.HashMap;
import java.util.Map;

public class Menu implements MenuInvoker {

    public final String EXIT = "Q";

    private final String title;
    private final HashMap<String, Command> actionMap = new HashMap<>();
    private final HashMap<String, String> optionMap = new HashMap<>();

    public Menu(String title) {
        this.title = title;
    }

    public void register(String selector, String option, Command action) {
        actionMap.put(selector, action);
        optionMap.put(selector, option);
    }

    public void execute(String selector) {
        Command action = actionMap.get(selector);

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

        for(Map.Entry<String, String> entry : optionMap.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue());
        }

        System.out.printf("%s. Sortir%n", EXIT);
    }
}
