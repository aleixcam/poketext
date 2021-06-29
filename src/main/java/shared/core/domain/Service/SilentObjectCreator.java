package shared.core.domain.Service;

public class SilentObjectCreator {

    public static <T> T create(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception exception) {
            throw new IllegalStateException("Cannot create object", exception);
        }
    }
}