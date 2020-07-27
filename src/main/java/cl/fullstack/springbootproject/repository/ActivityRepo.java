package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Activity;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepo extends GenericRepo<Activity, Long> {
}
