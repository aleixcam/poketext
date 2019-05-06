package application.command;

public interface MenuInvoker {

    void register(String selector, Command action, String option);
    void execute(String args);
    void print();
}
