package backend.proj1g2.Inscricoes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscricaoRepository extends MongoRepository<Inscricao, String> {

    Optional<Inscricao> findByUsuario(String userid);

    Optional<Inscricao> findByEvento(String eventid);

    void deleteByUsuario(String userid);
    void deleteByEvento(String eventid);
}
