package common.application.Command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Menu implements MenuInvoker {

    private final String EXIT = "Q";

    private final String title;
    private final HashMap<String, MenuOption> actions = new HashMap<>();

    public Menu(String title) {
        this.title = title;
    }

    public void register(String selector, Command action, String text) {
        actions.put(selector, new MenuOption(action, text));
    }

    public void execute(String selector) {
        selector = selector.toUpperCase();
        if (selector.equals(EXIT)) {
            return;
        }

        try {
            guardFromInvalidSelection(selector);
            MenuOption option = actions.get(selector);
            option.getAction().execute();
        } catch (InvalidSelectionException e) {
            System.out.print(e.getMessage());
        }
    }

    public void execute(String[] args) {
        String selector = args[0].toUpperCase();
        if (selector.equals(EXIT)) {
            return;
        }

        try {
            guardFromInvalidSelection(selector);
            MenuOption option = actions.get(selector);
            option.getAction().execute(Arrays.copyOfRange(args, 1, args.length));
        } catch (InvalidSelectionException e) {
            System.out.print(e.getMessage());
        }
    }

    public boolean isExit(String selector) {
        return selector.equalsIgnoreCase(EXIT);
    }

    public boolean isExit(String[] args) {
        return args[0].equalsIgnoreCase(EXIT);
    }

    public void print() {
        System.out.printf("%n%s%n", title);

        for(Map.Entry<String, MenuOption> entry : actions.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue().getText());
        }

        System.out.printf("%s. Sortir%n", EXIT);
    }

    private void guardFromInvalidSelection(String selector) throws InvalidSelectionException {
        if (!actions.containsKey(selector)) {
            throw new InvalidSelectionException();
        }
    }
}
