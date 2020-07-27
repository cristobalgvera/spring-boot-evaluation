package cl.fullstack.springbootproject.dao.visit;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.visit.Visit;
import cl.fullstack.springbootproject.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class VisitDAO extends AbstractDAO<Visit, Long, VisitRepo> {
    @Autowired
    public VisitDAO(VisitRepo genericRepo) {
        super(genericRepo);
    }
}
