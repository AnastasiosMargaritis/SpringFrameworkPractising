package user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String currencyCode;
    private String currencyName;


    @OneToMany(mappedBy = "country")
    private List<User> user;
}