package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {
}
