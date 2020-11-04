package zyxit.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zyxit.task.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
