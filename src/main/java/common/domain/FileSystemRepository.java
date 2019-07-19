package common.domain;

public interface FileSystemRepository<T> {

    T read(String name);
    void write(T entity, String path);
}
