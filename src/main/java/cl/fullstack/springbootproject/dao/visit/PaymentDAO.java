package cl.fullstack.springbootproject.dao.visit;

import cl.fullstack.springbootproject.dao.AbstractDAO;
import cl.fullstack.springbootproject.model.visit.Payment;
import cl.fullstack.springbootproject.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class PaymentDAO extends AbstractDAO<Payment, Long, PaymentRepo> {
    @Autowired
    public PaymentDAO(PaymentRepo genericRepo) {
        super(genericRepo);
    }
}
