package ru.kao.kaonotebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kao.kaonotebackend.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);

    boolean existsAccountByEmail(String email);
}
