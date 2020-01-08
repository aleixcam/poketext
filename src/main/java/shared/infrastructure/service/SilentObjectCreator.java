package shared.infrastructure.service;

import sun.reflect.ReflectionFactory;

public class SilentObjectCreator {

    public static <T> T create(Class<T> clazz) throws IllegalStateException {
        return create(clazz, Object.class);
    }

    public static <T> T create(Class<T> clazz, Class<? super T> parent) throws IllegalStateException {
        try {
            return clazz.cast(
                ReflectionFactory.getReflectionFactory().newConstructorForSerialization(
                    clazz,
                    parent.getDeclaredConstructor()
                ).newInstance()
            );
        } catch (Exception exception) {
            throw new IllegalStateException("Cannot create object", exception);
        }
    }
}