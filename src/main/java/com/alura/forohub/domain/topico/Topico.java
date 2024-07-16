package com.alura.forohub.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private String autor;
    private String curso;
    private String respuestas;

    public Topico(TopicoRegistroDTO topicoRegistroDTO){
        this.titulo = topicoRegistroDTO.titulo();
        this.mensaje = topicoRegistroDTO.mensaje();
        this.fecha = topicoRegistroDTO.fecha();
        this.autor=topicoRegistroDTO.autor();
        this.curso=topicoRegistroDTO.curso();
        this.respuestas=topicoRegistroDTO.respuestas();
    }

    public void atualizarInformacion(TopicoActualizarDTO datos) {
        if(datos.titulo() != null){
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null)
            this.mensaje = datos.mensaje();

    }
}
