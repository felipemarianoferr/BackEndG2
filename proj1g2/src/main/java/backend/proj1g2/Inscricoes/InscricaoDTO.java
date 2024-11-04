package backend.proj1g2.Inscricoes;


public record InscricaoDTO(String id, String usuario, String evento, Boolean ativo) {
}

record createInscricaoDTO(String usuario, String evento){
}

