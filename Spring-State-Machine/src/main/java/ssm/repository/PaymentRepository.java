package ssm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssm.domain.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
