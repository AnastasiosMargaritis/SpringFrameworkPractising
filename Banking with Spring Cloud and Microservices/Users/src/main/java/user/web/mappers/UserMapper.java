package user.web.mappers;

import org.mapstruct.Mapper;
import user.domain.User;
import user.web.model.UserDto;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
