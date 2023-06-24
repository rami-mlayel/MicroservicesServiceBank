package bank.service.repository;

import bank.service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM ACCOUNT WHERE ACCOUNT_NUMBER = ?1", nativeQuery = true)
    Account findByAccountNumber(String accountNumber);

    Account findByEmail(String email);
}
