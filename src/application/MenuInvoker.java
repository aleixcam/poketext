package application;

public interface MenuInvoker {

    void register(String selector, Command action, String option);
    void execute(String selector);
    void print();
}
