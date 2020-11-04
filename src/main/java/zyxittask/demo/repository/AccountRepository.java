package zyxittask.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zyxittask.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
