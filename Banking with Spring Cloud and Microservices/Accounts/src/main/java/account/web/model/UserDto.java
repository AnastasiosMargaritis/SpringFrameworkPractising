package account.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto implements Serializable {

    static final long serialVersionUID = -5815566940065181210L;

    @Id
    @NotNull
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(min = 4, max = 4)
    private String password;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 10, max = 10)
    private String mobileNumber;

    @NotBlank
    @Size(min = 2, max = 3)
    private String countryCode;

    @NotNull
    private AccountDto account;
}
