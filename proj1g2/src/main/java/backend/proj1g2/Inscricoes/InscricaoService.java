package backend.proj1g2.Inscricoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;



@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;



    // CREATE
    public InscricaoDTO createInscricao(createInscricaoDTO dto) {
        Inscricao inscricao = new Inscricao();
        inscricao.setUsuario(dto.usuario());
        inscricao.setEvento(dto.evento());
        inscricao.setActive(true);
        Inscricao inscricao_ = inscricaoRepository.save(inscricao);
        return NormParaDto(inscricao_.getId());
    }



    // GET
    public InscricaoDTO getInscricaoById(String id) {

        Inscricao inscricao =  inscricaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return NormParaDto(inscricao.getId());
    }

    public Page<Inscricao> getInscricaoByUsuario(String userid, Pageable pageable) {
        return inscricaoRepository.findByUsuario(userid, pageable);      // .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Page<Inscricao> getInscricaoByEvento(String eventid, Pageable pageable) {
        return inscricaoRepository.findByEvento(eventid, pageable);      //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Page<Inscricao> getAllInscricoes(Pageable pageable) {
        return inscricaoRepository.findAll(pageable);
    }

    // ATIVAR / DESATIVAR
    public InscricaoDTO deleteInscricao(String id) {
        Inscricao inscricao = inscricaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        inscricao.setActive(!inscricao.getActive());
        return NormParaDto(inscricao.getId());
    }

    public InscricaoDTO NormParaDto(String id) {
        Inscricao inscricao = inscricaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new InscricaoDTO(inscricao.getId(), inscricao.getUsuario(), inscricao.getEvento(), inscricao.getActive());
    }
}
