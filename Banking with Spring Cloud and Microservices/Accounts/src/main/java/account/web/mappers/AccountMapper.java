package account.web.mappers;

import account.domain.Account;
import account.web.model.AccountDto;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    Account accountDtoToAccount(AccountDto dto);
    AccountDto accountToAccountDto(Account account);
}
