package user.events;

import lombok.*;
import user.domain.User;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class UserEvent implements Serializable {

    static final long serialVersionUID = 8622444018599799712L;

    private User user;
}
