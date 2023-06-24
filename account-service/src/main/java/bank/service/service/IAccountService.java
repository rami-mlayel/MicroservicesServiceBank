package bank.service.service;

import bank.service.exception.AccountNotFoundException;
import bank.service.repository.AccountRepository;
import bank.service.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IAccountService implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return  accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account accountDto, Long id) throws AccountNotFoundException {
        Optional<Account> account = this.accountRepository.findById(id);
        if (account.isPresent()) {
            return this.accountRepository.save(accountDto);
        } else {
            throw new AccountNotFoundException(id);
        }
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
