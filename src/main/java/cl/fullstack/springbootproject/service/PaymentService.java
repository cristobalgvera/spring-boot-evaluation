package cl.fullstack.springbootproject.service;

import cl.fullstack.springbootproject.dao.visit.PaymentDAO;
import cl.fullstack.springbootproject.model.visit.Payment;
import cl.fullstack.springbootproject.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends GenericService<Payment, Long, PaymentRepo, PaymentDAO> {
    @Autowired
    PaymentService(PaymentDAO paymentDAO) {
        super(paymentDAO);
    }
}
