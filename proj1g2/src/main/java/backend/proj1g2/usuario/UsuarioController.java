package backend.proj1g2.usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/projeto/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarUsuarioDTO cadastraUsuario(@Valid @RequestBody CadastraUsuarioDTO usuario){
        return usuarioService.cadastraUsuario(usuario);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(@RequestParam(required = false) String nome,
                                        Pageable pageable) {
        return usuarioService.listarUsuarios(nome, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirUsuario(@PathVariable String id, Pageable pageable) {
        usuarioService.excluirUsuario(id, pageable);
    }

    @GetMapping("/total-pages")
    public int contarPaginas(@RequestParam(required = false) String nome, Pageable pageable) {
        Page<Usuario> page = usuarioService.listarUsuarios(nome, pageable);
        return page.getTotalPages();  // This will return the total number of pages
    }
}
