package hospital.repositories.interfaces;

import java.util.List;

public interface IRepository<T> {
    void add(T entity);
    void update(T entity);
    void delete(T entity);
    void save(Object dependent);

    T getById(int id);
    List<T> getAll();
    T getByField(String name, Object value);

    void close();
}
