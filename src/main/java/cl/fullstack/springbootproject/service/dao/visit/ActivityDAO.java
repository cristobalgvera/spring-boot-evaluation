package cl.fullstack.springbootproject.service.dao.visit;

import cl.fullstack.springbootproject.model.visit.Activity;
import cl.fullstack.springbootproject.repository.ActivityRepo;
import cl.fullstack.springbootproject.service.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ActivityDAO implements DAO<Activity, Long> {

    @Autowired
    private ActivityRepo activityRepo;

    @Override
    public Optional<Activity> getOne(Long id) {
        return Optional.ofNullable(activityRepo.getOne(id));
    }

    @Override
    public Collection<Activity> getAll() {
        return activityRepo.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Activity save(Activity activity) {
        return activityRepo.save(activity);
    }

    @Override
    public void update(Activity activity) {
        Activity dbActivity = getOne(activity.getId())
                .orElseThrow(() -> new EntityNotFoundException("Not found activity: " + activity.getId()));

        if(activity.isReady() != dbActivity.isReady())
            dbActivity.setReady(activity.isReady());

        if (!activity.getDescription().equals(dbActivity.getDescription()))
            dbActivity.setDescription(activity.getDescription());

        if (activity.getSchedulingDate() != dbActivity.getSchedulingDate())
            dbActivity.setSchedulingDate(activity.getSchedulingDate());

        activityRepo.save(dbActivity);
    }

    @Override
    public void delete(Long id) {
        activityRepo.deleteById(id);
    }
}
