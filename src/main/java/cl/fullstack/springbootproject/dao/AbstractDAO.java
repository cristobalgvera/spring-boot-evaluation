package cl.fullstack.springbootproject.dao;

import cl.fullstack.springbootproject.repository.GenericRepo;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public abstract class AbstractDAO<Entity extends AbstractPersistable<ID>, ID extends Serializable,
        Repository extends GenericRepo<Entity, ID>> implements DAO<Entity, ID> {

    protected final Repository genericRepo;

    public AbstractDAO(Repository genericRepo) {
        this.genericRepo = genericRepo;
    }

    @Override
    public Optional<Entity> getOne(ID id) {
        return Optional.ofNullable(genericRepo.getOne(id));
    }

    @Override
    public Collection<Entity> getAll() {
        return genericRepo.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Entity save(Entity entity) {
        return genericRepo.save(entity);
    }

    @Override
    public void update(Entity entity) {
        genericRepo.save(entity);
//        Entity dbEntity = getOne(entity.getId())
//                .orElseThrow(() -> new EntityNotFoundException("Not found entity " +
//                        entity.getClass().getName() + ": " + entity.getId()));
//
//        Field[] attributes = entity.getClass().getDeclaredFields();
//
//        for (var attribute : attributes) {
//            try {
//                // Dynamically set attribute value
//                PropertyUtils.setSimpleProperty(dbEntity, attribute.getName(), attribute.get(entity));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void delete(ID id) {
        genericRepo.deleteById(id);
    }
}
