package transactions.domain;

public enum TransactionEvent {
    VALIDATE_NEW_ACCOUNT, VALIDATE_WITHDRAW, VALIDATE_DEPOSIT, VALIDATE_DELETE_ACCOUNT, VALIDATION_PASSED, VALIDATION_FAILED
}
