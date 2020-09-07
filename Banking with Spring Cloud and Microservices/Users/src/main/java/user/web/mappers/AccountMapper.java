package user.web.mappers;

import org.mapstruct.Mapper;
import user.domain.Account;
import user.web.model.AccountDto;

@Mapper
public interface AccountMapper {

    Account accountDtoToAccount(AccountDto accountDto);
    AccountDto accountToAccountDto(Account account);
}
