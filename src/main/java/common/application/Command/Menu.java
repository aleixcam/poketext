package common.application.Command;

import common.infrastructure.service.ReaderService;

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

    public void execute() {
        String[] args;

        do {
            args = print();
            args[0] = args[0].toUpperCase();

            execute(args);
        } while (!isExit(args[0]));
    }

    private void execute(String... args) {
        if (isExit(args[0])) {
            return;
        }

        if (!isValidSelection(args[0])) {
            System.out.print("Invalid selection");
            return;
        }

        MenuOption option = actions.get(args[0]);
        option.getAction().execute(Arrays.copyOfRange(args, 1, args.length));
    }

    private boolean isExit(String... args) {
        return args[0].equalsIgnoreCase(EXIT);
    }

    private boolean isValidSelection(String selector) {
        return actions.containsKey(selector);
    }

    public String[] print() {
        System.out.printf("%n%s%n", title);

        for(Map.Entry<String, MenuOption> entry : actions.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue().getText());
        }

        System.out.printf("%s. Sortir%n", EXIT);

        return ReaderService.toArray();
    }
}
