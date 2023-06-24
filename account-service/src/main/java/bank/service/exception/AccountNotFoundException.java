package bank.service.exception;


public class AccountNotFoundException extends Throwable {
    public AccountNotFoundException(Long id) {
        super("Cannot found account number [" + id + "]");
    }
}
