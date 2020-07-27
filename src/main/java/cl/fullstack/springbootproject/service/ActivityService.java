package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.ActivityDAO;
import cl.fullstack.springbootproject.model.visit.Activity;
import cl.fullstack.springbootproject.repository.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService extends GenericService<Activity, Long, ActivityRepo, ActivityDAO> {

    @Autowired
    ActivityService(ActivityDAO activityDAO) {
        super(activityDAO);
    }
}
