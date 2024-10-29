package backend.proj1g2.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public RetornarUsuarioDTO cadastraUsuario(CadastraUsuarioDTO dto) {

        Usuario usuarioDB = usuarioRepository.findByEmail(dto.email());

        if (usuarioDB == null){
            Usuario usuario = new Usuario();
            usuario.setNome(dto.nome());
            usuario.setEmail(dto.email());
            usuario.setCidade(dto.cidade());
            usuario.setDataNascimento(dto.dataNascimento());
            usuario = usuarioRepository.save(usuario);
            return  new RetornarUsuarioDTO(usuario.getId(), usuario.getNome(),
                    usuario.getEmail(), usuario.getCidade(), usuario.getDataNascimento());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

    public Page<Usuario> listarUsuarios(String nome, Pageable pageable){
        if (nome != null){
            return usuarioRepository.findByNome(nome, pageable);
        }
        return usuarioRepository.findAll(pageable);
    }

    public Usuario buscarUsuario(String id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void excluirUsuario(String id){
        Usuario usuario = buscarUsuario(id);
        usuarioRepository.delete(usuario);
//      Preciso verificar se o usuario nunca se inscreveu em um evento
//      para deletar o usuario
    }
}
