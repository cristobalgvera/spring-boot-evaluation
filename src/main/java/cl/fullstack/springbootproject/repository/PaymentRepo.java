package cl.fullstack.springbootproject.repository;

import cl.fullstack.springbootproject.model.visit.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}
