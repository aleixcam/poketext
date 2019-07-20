package common.domain;

public interface FileSystemRepository<T> {

    T read(String name);
    void write(T entity, String name);
    void erase(String name);
    String[] list();
}
