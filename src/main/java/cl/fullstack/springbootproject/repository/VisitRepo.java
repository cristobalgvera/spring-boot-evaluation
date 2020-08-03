package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Visit;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VisitRepo extends GenericRepo<Visit, Long> {
    Collection<Visit> findAllByEmployee_Id(Long employeeId);
}
