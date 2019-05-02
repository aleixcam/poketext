package infrastructure.service;

import java.util.HashMap;

public class MenuService {

    private final HashMap<String, Action> commandMap = new HashMap<>();

    public void register(String id, Action command) {
        commandMap.put(id, command);
    }

    public void execute(String id) {
        Action command = commandMap.get(id);

        if (command == null) {
            System.out.println("Invalid selection");
            return;
        }

        command.execute();
    }
}
