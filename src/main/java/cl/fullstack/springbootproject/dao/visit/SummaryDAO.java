package cl.fullstack.springbootproject.dao.visit;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.visit.Summary;
import cl.fullstack.springbootproject.repository.SummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SummaryDAO extends AbstractDAO<Summary, Long, SummaryRepo> {
    @Autowired
    public SummaryDAO(SummaryRepo genericRepo) {
        super(genericRepo);
    }
}
