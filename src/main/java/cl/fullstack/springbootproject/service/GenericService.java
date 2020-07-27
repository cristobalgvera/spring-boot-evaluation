package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.repository.GenericRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional
public abstract class GenericService<Entity extends AbstractPersistable<ID>, ID extends Serializable,
        Repository extends GenericRepo<Entity, ID>, EntityDAO extends AbstractDAO<Entity, ID, Repository>>
        extends AbstractCRUD<Entity, ID, Repository, EntityDAO> {
    GenericService(EntityDAO entityDAO) {
        super(entityDAO);
    }
}
