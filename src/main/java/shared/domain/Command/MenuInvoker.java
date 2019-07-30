package shared.domain.Command;

public interface MenuInvoker {

    void register(String selector, Command action, String option);
    void execute();
}
