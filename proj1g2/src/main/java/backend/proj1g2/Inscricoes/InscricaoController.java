package backend.proj1g2.Inscricoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/projeto/v1/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    // CREATE - Cria uma nova inscrição
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InscricaoDTO createInscricao(@RequestBody createInscricaoDTO dto) {
        return inscricaoService.createInscricao(dto);
    }

    // GET - Lista todas as inscrições com paginação
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Inscricao> getAllInscricoes(Pageable pageable) {
        return inscricaoService.getAllInscricoes(pageable);
    }

    // GET - Busca inscrição por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InscricaoDTO getInscricaoById(@PathVariable String id) {
        return inscricaoService.getInscricaoById(id);
    }

    // GET - Lista inscrições por usuário com paginação
    @GetMapping("/usuario/{userid}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Inscricao> getInscricaoByUsuario(@PathVariable String userid, Pageable pageable) {
        return inscricaoService.getInscricaoByUsuario(userid, pageable);
    }

    // GET - Lista inscrições por evento com paginação
    @GetMapping("/evento/{eventid}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Inscricao> getInscricaoByEvento(@PathVariable String eventid, Pageable pageable) {
        return inscricaoService.getInscricaoByEvento(eventid, pageable);
    }

    // DELETE - Desativa uma inscrição (toggle active status)
    @PutMapping("/desativar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InscricaoDTO toggleInscricaoStatus(@PathVariable String id) {
        return inscricaoService.deleteInscricao(id);
    }
}
