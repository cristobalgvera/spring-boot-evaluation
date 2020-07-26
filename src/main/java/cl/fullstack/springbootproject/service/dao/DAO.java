package cl.fullstack.springbootproject.service.dao;

import java.util.Collection;
import java.util.Optional;

public interface DAO<T, S> {
    Optional<T> getOne(S id);

    Collection<T> getAll();

    T save(T t);

    void update(T t) throws NoSuchFieldException;

    void delete(S id);
}
