package backend.proj1g2.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

        Page <Usuario> findByNome(String nome, Pageable pageable);

        Usuario findByEmail(String email);
}
