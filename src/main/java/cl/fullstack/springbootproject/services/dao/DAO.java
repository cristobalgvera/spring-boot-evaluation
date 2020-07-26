package cl.fullstack.springbootproject.services.dao;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T, S> {
    Optional<T> getOne(S id);

    Collection<T> getAll();

    T save(T t);

    void update(T t);

    void delete(S id);
}
