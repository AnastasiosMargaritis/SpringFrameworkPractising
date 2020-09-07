package account.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import account.domain.User;

import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UserEvent implements Serializable {

    static final long serialVersionUID = 8622444018599799712L;

    private User user;
}
