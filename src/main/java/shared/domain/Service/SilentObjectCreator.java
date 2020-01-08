package shared.domain.Service;

import sun.reflect.ReflectionFactory;

public class SilentObjectCreator {

    public static <T> T create(Class<T> clazz) throws IllegalStateException {
        try {
            return clazz.cast(
                ReflectionFactory.getReflectionFactory().newConstructorForSerialization(
                    clazz,
                    Object.class.getDeclaredConstructor()
                ).newInstance()
            );
        } catch (Exception exception) {
            throw new IllegalStateException("Cannot create object", exception);
        }
    }
}