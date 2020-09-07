package account.web.mappers;

import account.domain.User;
import account.web.model.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDto dto);
    UserDto userToUserDto(User user);
}
