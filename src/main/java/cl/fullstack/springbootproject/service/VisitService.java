package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.VisitDAO;
import cl.fullstack.springbootproject.model.visit.Visit;
import cl.fullstack.springbootproject.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VisitService extends GenericService<Visit, Long, VisitRepo, VisitDAO> {
    @Autowired
    VisitService(VisitDAO visitDAO) {
        super(visitDAO);
    }

    @Autowired
    private VisitRepo visitRepo;

    public Collection<Visit> findAllVisitsByEmployeeId(Long employeeId) {
        return visitRepo.findAllByEmployee_Id(employeeId);
    }
}
