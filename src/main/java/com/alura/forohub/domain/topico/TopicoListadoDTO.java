package com.alura.forohub.domain.topico;

public record TopicoListadoDTO(Long id, String autor, String titulo, String mensaje) {
    public  TopicoListadoDTO(Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje());
    }
}
