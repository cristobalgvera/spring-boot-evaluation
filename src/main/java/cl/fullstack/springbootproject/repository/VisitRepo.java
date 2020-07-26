package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepo extends JpaRepository<Visit, Long> {
}
