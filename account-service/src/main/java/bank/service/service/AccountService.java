package bank.service.service;

import bank.service.exception.AccountNotFoundException;
import bank.service.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {
    Account addAccount (Account account);
     List<Account> getAllAccounts();
     Optional<Account> getAccountById(Long id);
     Account createAccount(Account account);
     Account updateAccount(Account account, Long id) throws AccountNotFoundException;
     void deleteAccount(Long id);
}
