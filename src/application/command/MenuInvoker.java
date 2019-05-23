package application.command;

public interface MenuInvoker {

    void register(String selector, Command action, String option);
    void execute(String selector);
    void execute(String[] args);
    boolean isExit(String selector);
    boolean isExit(String[] args);
}
