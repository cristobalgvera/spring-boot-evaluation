package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.Collection;

public abstract class AbstractCRUD<Entity extends AbstractPersistable<ID>, ID extends Serializable,
        Repository extends GenericRepo<Entity, ID>, EntityDAO extends AbstractDAO<Entity, ID, Repository>> {

    protected final EntityDAO entityDAO;

    AbstractCRUD(EntityDAO entityDAO) {
        this.entityDAO = entityDAO;
    }

    public Entity save(Entity entity) {
        return (Entity) entityDAO.save(entity);
    }

    public Entity getOne(ID id) {
        return (Entity) entityDAO.getOne(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found: " + id));
    }

    public Collection<Entity> getAll() {
        return entityDAO.getAll();
    }

    public void update(Entity entity) {
        entityDAO.update(entity);
    }

    public void delete(ID id) {
        entityDAO.delete(id);
    }
}
