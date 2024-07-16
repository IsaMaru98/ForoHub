package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record TopicoActualizarDTO(
        String titulo,
        String mensaje
) {
}
