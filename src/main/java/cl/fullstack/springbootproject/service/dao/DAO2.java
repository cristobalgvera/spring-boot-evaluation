package cl.fullstack.springbootproject.service.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DAO2 <T extends Serializable, E> {
    void deleteAll(Collection<T> instances) throws Exception;
    int bulkUpdate(String query) throws Exception;
    E save(T instance) throws Exception;
    void saveOrUpdate(T instance) throws Exception;
    void persist(T transientInstance) throws Exception;
    void attachDirty(T instance) throws Exception;
    void attachClean(T instance) throws Exception;
    void delete(T persistentInstance) throws Exception;
    List<T> findByExample(T instance) throws Exception;
    List<T> findByQuery(String query) throws Exception;
    List<Map<String, Object>> findMapByQuery(String queryString) throws Exception;
    List<T> findByCriteria(DetachedCriteria criteria) throws Exception;
    T merge(T detachedInstance) throws Exception;
    List<T> findAll() throws Exception;
    T findById(E id) throws Exception;
}
