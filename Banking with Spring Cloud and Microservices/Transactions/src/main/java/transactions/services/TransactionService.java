package transactions.services;

import transactions.domain.Transaction;

public interface TransactionService {

        Transaction newTransaction(Transaction transaction);
}
