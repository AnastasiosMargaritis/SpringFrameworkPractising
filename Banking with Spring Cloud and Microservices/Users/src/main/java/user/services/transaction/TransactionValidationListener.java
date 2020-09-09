package user.services.transaction;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import user.config.JsmConfig;
import user.web.model.events.TransactionRequest;
import user.web.model.events.TransactionRequestResult;

@RequiredArgsConstructor
@Component
public class TransactionValidationListener {

    private final TransactionValidator validator;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JsmConfig.VALIDATE_TRANSACTION_QUEUE)
    public void listen(TransactionRequest transactionRequest){

        Boolean isValid = validator.validateTransaction(transactionRequest.getDto());

        jmsTemplate.convertAndSend(JsmConfig.VALIDATE_TRANSACTION_RESPONSE_QUEUE,
                TransactionRequestResult.builder()
                .isValid(isValid)
                .accountId(transactionRequest.getDto().getId())
                .build());
    }
}
