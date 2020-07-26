package cl.fullstack.springbootproject.service.dao;

import cl.fullstack.springbootproject.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.apache.commons.beanutils.PropertyUtils;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractDAO<T extends AbstractPersistable<S>, S extends Serializable> implements DAO<T, S> {

    @Autowired
    private GenericRepo<T, S> genericRepo;

    @Override
    public Optional<T> getOne(S id) {
        return Optional.ofNullable(genericRepo.getOne(id));
    }

    @Override
    public Collection<T> getAll() {
        return genericRepo.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public T save(T t) {
        return genericRepo.save(t);
    }

    @Override
    public void update(T t) {
        T dbEntity = getOne(t.getId())
                .orElseThrow(() -> new EntityNotFoundException("Not found entity " +
                        t.getClass().getName() + ": " + t.getId()));

        Field[] attributes = t.getClass().getDeclaredFields();

        for (var attribute : attributes) {
            try {
                // Dynamically set attribute value
                PropertyUtils.setSimpleProperty(dbEntity, attribute.getName(), attribute.get(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(S id) {
        genericRepo.deleteById(id);
    }
}
