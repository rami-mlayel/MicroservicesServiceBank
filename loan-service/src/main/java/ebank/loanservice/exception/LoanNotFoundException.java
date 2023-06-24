package ebank.loanservice.exception;

import java.util.UUID;

public class LoanNotFoundException extends Throwable {
    public LoanNotFoundException(Long id) {
        super("Cannot find evaluation number [" + id + "]");
    }
}
