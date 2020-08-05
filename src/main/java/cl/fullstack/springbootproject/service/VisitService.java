package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.VisitDAO;
import cl.fullstack.springbootproject.model.visit.Visit;
import cl.fullstack.springbootproject.repository.VisitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

    public Map<String, Object> getMappedVisitDetails(Long visitId) {
        Visit visit = visitRepo.getOne(visitId);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("visit", visit);
        attributes.put("address", visit.getAddress());
        attributes.put("payment", visit.getPayment());
        attributes.put("activities", visit.getActivities());
        attributes.put("employee", visit.getEmployee());
        attributes.put("customer", visit.getCustomer());
        attributes.put("summary", visit.getSummary());
        return attributes;
    }
}
