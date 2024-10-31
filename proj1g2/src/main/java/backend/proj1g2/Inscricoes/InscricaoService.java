package backend.proj1g2.Inscricoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InscricaoService {

    @Autowired
    private InscricaoRepository inscricaoRepository;


    public Inscricao createInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao deleteInscricaoById(String id) {
        inscricaoRepository.deleteById(id);
        return getInscricaoById(id);
    }

    public Inscricao deleteInscricaoByUsuario(String userid) {
        inscricaoRepository.deleteByUsuario(userid);
        return getInscricaoByUsuario(userid);
    }

    public Inscricao deleteInscricaoByEvento(String eventid) {
        inscricaoRepository.deleteByEvento(eventid);
        return getInscricaoByEvento(eventid);
    }

    public Inscricao getInscricaoById(String id) {
        return inscricaoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Inscricao getInscricaoByUsuario(String userid) {
        return inscricaoRepository.findByUsuario(userid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Inscricao getInscricaoByEvento(String eventid) {
        return inscricaoRepository.findByEvento(eventid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
