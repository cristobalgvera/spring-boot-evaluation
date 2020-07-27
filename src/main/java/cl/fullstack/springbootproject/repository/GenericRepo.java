package cl.fullstack.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepo<Entity, ID extends Serializable> extends JpaRepository<Entity, ID> {
}
