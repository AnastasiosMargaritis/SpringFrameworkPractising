package account.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private String iban;

    @Lob
    HashMap<String, Double> money = new HashMap<>();

    @NotNull
    private UserDto userDto;
}
