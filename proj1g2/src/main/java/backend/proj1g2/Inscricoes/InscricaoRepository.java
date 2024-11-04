package backend.proj1g2.Inscricoes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface InscricaoRepository extends MongoRepository<Inscricao, String> {


    // GET
    Page<Inscricao> findByUsuario(String userid, Pageable pageable);
    Page<Inscricao> findByEvento(String eventid, Pageable pageable);

}
