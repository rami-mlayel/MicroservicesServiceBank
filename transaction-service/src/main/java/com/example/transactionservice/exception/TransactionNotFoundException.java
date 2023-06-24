package com.example.transactionservice.exception;

import java.util.UUID;

public class TransactionNotFoundException extends Throwable {
    public TransactionNotFoundException(UUID id) {
        super("Cannot found employee number [" + id + "]");
    }
}
