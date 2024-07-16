package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    TopicoRepository topicoRepository;

    // Registrar nuevos topicos
    @PostMapping()
    public ResponseEntity<TopicoRegistroDTO> agregarTopico(@RequestBody TopicoRegistroDTO topicoRegistroDTO,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        System.out.println(topicoRegistroDTO);
        Topico topico = topicoRepository.save(new Topico(topicoRegistroDTO));
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url). body(topicoRegistroDTO);
    }
    // listar todos los post
    @GetMapping()
    public ResponseEntity<Page<TopicoListadoDTO>> listadoTopicos(@PageableDefault(size=2) Pageable pageable){
        return ResponseEntity.ok(topicoRepository.findAll(pageable).map(TopicoListadoDTO::new));

    }

    // mostrar un post por ID
    @GetMapping("/{id}")
    public ResponseEntity mostrarTopico(@PathVariable Long id){
        try {
            Topico topico = topicoRepository.getReferenceById(id);
            TopicoRespuestaDTO topicoRespuestaDTO =  new TopicoRespuestaDTO(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getAutor(),topico.getCurso(),topico.getRespuestas());
            return ResponseEntity.ok(topicoRespuestaDTO);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("No se encuentra ese topico en la base de datos");
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity acualizar(@RequestBody @Valid TopicoActualizarDTO datos, @PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.atualizarInformacion(datos);
        TopicoRespuestaDTO topicoRespuestaDTO =  new TopicoRespuestaDTO(topico.getId(), topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getAutor(),topico.getCurso(),topico.getRespuestas());
        return  ResponseEntity.ok(topicoRespuestaDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public  ResponseEntity eliminar(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();

    }



}

