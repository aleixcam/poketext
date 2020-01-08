package shared.core.domain.Service;

import sun.reflect.ReflectionFactory;

public class SilentObjectCreator {

    public static <T> T create(Class<T> clazz) throws RuntimeException {
        try {
            return clazz.cast(
                ReflectionFactory.getReflectionFactory().newConstructorForSerialization(
                        clazz,
                        clazz.getSuperclass().getDeclaredConstructor()
                ).newInstance()
            );
        } catch (RuntimeException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new IllegalStateException("Cannot create object", exception);
        }
    }
}