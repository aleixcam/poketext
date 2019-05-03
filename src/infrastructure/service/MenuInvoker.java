package infrastructure.service;

public interface MenuInvoker {

    void register(String selector, String option, Command action);
    void execute(String selector);
    void print();
}
