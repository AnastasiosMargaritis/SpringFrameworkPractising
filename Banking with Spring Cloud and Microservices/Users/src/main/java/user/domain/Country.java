package user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String currencyCode;
    private String currencyName;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<User> users = new ArrayList<>();
}