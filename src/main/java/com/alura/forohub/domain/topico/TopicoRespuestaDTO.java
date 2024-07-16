package com.alura.forohub.domain.topico;

public record TopicoRespuestaDTO(
         Long id,
         String titulo,
         String mensaje,
         String fecha,
         String autor,
         String curso,
         String respuestas
) {
}
