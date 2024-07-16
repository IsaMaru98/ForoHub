package com.alura.forohub.domain.topico;
import jakarta.validation.constraints.NotBlank;

public record TopicoRegistroDTO(
        String mensaje,

        String autor,

        String titulo,

        String fecha,

        String curso,
        String respuestas) {
}
