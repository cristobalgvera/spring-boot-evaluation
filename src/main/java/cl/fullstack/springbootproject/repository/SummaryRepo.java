package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Summary;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepo extends GenericRepo<Summary, Long> {
}
