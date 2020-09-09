package account.services.transactions;

import account.domain.Account;

public interface TransactionManager {

    Account generateNewAccount(Account account);
}
