package backend.proj1g2.usuario;

record CadastraUsuarioDTO
        (String nome, String email, String cidade, String dataNascimento){
}

record RetornarUsuarioDTO(String id, String nome, String email, String cidade, String dataNascimento) {}
