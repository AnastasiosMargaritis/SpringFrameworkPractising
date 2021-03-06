package user.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto implements Serializable {

    @Id
    @NotNull
    private UUID id;

    @NotNull
    private String iban;

    @Lob
    HashMap<String, Double> money = new HashMap<>();

    @NotNull
    private UserDto userDto;
}
