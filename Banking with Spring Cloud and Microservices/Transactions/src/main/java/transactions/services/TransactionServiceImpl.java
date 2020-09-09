package transactions.services;

import lombok.RequiredArgsConstructor;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import transactions.domain.Transaction;
import transactions.domain.TransactionEvent;
import transactions.domain.TransactionStatus;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final StateMachineFactory<TransactionStatus, TransactionEvent> sm;

    @Transactional
    @Override
    public Transaction newTransaction(Transaction transaction) {


        return null;
    }
}
