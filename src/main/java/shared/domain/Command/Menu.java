package shared.domain.Command;

import shared.infrastructure.service.ReaderService;

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
            args = render();
            args[0] = args[0].toUpperCase();
        } while (execute(args));
    }

    private boolean execute(String... args) {
        if (args[0].equalsIgnoreCase(EXIT)) {
            return false;
        }

        try {
            MenuOption option = actions.get(args[0]);
            option.getAction().execute(Arrays.copyOfRange(args, 1, args.length));
        } catch (Exception exception) {
            System.out.printf("Invalid selection%n");
        }

        return true;
    }

    private String[] render() {
        System.out.printf("%n%s%n", title);

        for(Map.Entry<String, MenuOption> entry : actions.entrySet()) {
            System.out.printf("%s. %s%n", entry.getKey(), entry.getValue().getText());
        }

        System.out.printf("%s. Sortir%n", EXIT);

        return ReaderService.toArray();
    }
}
