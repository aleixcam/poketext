package application.command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu implements MenuInvoker {

    public final String EXIT = "Q";

    private final String title;
    private final HashMap<String, MenuOption> actions = new HashMap<>();

    public Menu(String title) {
        this.title = title;
    }

    public void register(String selector, Command action, String text) {
        actions.put(selector, new MenuOption(action, text));
    }

    public void execute(String selector) {
        if (selector.equals(EXIT)) {
            return;
        }

        MenuOption option = actions.get(selector);
        if (option == null) {
            System.out.println("Invalid selection");
            return;
        }

        option.getAction().execute();
    }

    public void execute(String[] args) {
        if (args[0].equals(EXIT)) {
            return;
        }

        MenuOption option = actions.get(args[0]);
        if (option == null) {
            System.out.println("Invalid selection");
            return;
        }

        option.getAction().execute(Arrays.copyOfRange(args, 1, args.length));
    }

    public void print() {
        System.out.printf("%n%s%n", title);

        for(Map.Entry<String, MenuOption> entry : actions.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue().getText());
        }

        System.out.printf("%s. Sortir%n", EXIT);
    }
}
