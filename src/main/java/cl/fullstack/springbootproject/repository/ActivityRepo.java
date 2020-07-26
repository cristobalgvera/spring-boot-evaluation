package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends JpaRepository<Activity, Long> {
}
