package user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import user.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
