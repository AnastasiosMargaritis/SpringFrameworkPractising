package user.web.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import user.domain.User;
import user.web.model.UserDto;

@Mapper
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
