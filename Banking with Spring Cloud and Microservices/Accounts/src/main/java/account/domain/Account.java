package account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String iban;

    @Lob
    private HashMap<String, Double> money = new HashMap<>();

    private TransactionStatus status = TransactionStatus.NO_STATUS;

    @OneToOne(mappedBy = "account")
    @JsonIgnore
    private User user;

    public String generateIBAN(){
        String iban = "GB78 REVO ";
        String digits = "0123456789";
        Random random = new Random();

        for(int i = 1; i <= 14; i++){

            if(i % 5 == 0 && i > 0){
                iban += " ";
            }else{

                iban += digits.charAt(random.nextInt(10));
            }
        }
        return iban;
    }
}
