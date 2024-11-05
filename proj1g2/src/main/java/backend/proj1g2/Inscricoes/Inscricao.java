package backend.proj1g2.Inscricoes;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Inscricao {

    @Id
    private String id;

    @NotEmpty
    private String usuario;

    @NotEmpty
    private String evento;

    private Boolean active;

    public Inscricao(String usuario, String evento) {
    }

}
