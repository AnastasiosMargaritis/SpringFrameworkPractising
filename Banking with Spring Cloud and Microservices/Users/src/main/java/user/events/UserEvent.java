package user.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import user.domain.User;

import java.io.Serializable;

@RequiredArgsConstructor
@Data
@Builder
public class UserEvent implements Serializable {

    static final long serialVersionUID = 8622444018599799712L;

    private final User userDto;
}
