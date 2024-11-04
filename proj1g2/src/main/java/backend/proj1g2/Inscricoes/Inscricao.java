package backend.proj1g2.Inscricoes;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Inscricao {

    @Id
    private String id;

    @NotEmpty
    private String user;

    @NotEmpty
    private String event;

    private Boolean active;

    public Inscricao(String user, String event) {
    }
}
