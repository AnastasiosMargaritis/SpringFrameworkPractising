package banking.web.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryDto implements Serializable {

    static final long serialVersionUID = -5815566940065181210L;

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 2, max = 2)
    private String alpha2Code;

    @NotBlank
    @Size(min = 3, max = 3)
    private String alpha3Code;

    @NotBlank
    @Size(min = 3, max = 3)
    private String currencyCode;

    private String currencyName;
}
