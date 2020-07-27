package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.SummaryDAO;
import cl.fullstack.springbootproject.model.visit.Summary;
import cl.fullstack.springbootproject.repository.SummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryService extends GenericService<Summary, Long, SummaryRepo, SummaryDAO> {
    @Autowired
    SummaryService(SummaryDAO summaryDAO) {
        super(summaryDAO);
    }
}
