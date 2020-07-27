package cl.fullstack.springbootproject.dao.visit;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.visit.Activity;
import cl.fullstack.springbootproject.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class ActivityDAO extends AbstractDAO<Activity, Long, ActivityRepo> {
    @Autowired
    public ActivityDAO(ActivityRepo genericRepo) {
        super(genericRepo);
    }
}
