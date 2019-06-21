package common.application.Command;

public interface MenuInvoker {

    void register(String selector, Command action, String option);
    void execute(String... args);
    boolean isExit(String... args);
}
