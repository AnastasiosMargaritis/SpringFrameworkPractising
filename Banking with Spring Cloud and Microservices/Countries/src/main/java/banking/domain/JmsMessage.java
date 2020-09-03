package banking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JmsMessage implements Serializable {

    static final long serialVersionUID = 4362238910415956483L;

    private UUID id;
    private String message;
}
