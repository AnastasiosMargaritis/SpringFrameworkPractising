package user.web.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CountryDto implements Serializable {

    static final long serialVersionUID = -5815566940065181210L;

    @NotBlank
    private String name;

    @NotBlank
    private String alpha2Code;

    @NotBlank
    private String alpha3Code;

    @NotBlank
    private String currencyCode;

    @NotBlank
    private String currencyName;


    private List<UserDto> users = new ArrayList<>();

}
