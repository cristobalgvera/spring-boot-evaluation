package cl.fullstack.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenericRepo<T, S extends Serializable> extends JpaRepository<T, S> {
}
