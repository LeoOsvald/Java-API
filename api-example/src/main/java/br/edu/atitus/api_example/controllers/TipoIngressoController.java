package br.edu.atitus.api_example.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoRequestDTO;
import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoResponseDTO;
import br.edu.atitus.api_example.services.TipoIngressoService;

@RestController
@RequestMapping("/tipos-ingresso")
public class TipoIngressoController {

    private final TipoIngressoService service;

    public TipoIngressoController(TipoIngressoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TipoIngressoResponseDTO> criar(@RequestBody TipoIngressoRequestDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoIngressoResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TipoIngressoRequestDTO dto) {

        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoIngressoResponseDTO> buscarPorId(@PathVariable Long id) {

        var result = service.buscarPorId(id);
        if (result == null) 
            return ResponseEntity.notFound().build();
    
        return ResponseEntity.ok(result);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<TipoIngressoResponseDTO> buscarPorNome(@PathVariable String nome) {

        var result = service.buscarPorNome(nome);
        if (result == null) 
            return ResponseEntity.notFound().build();
    
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<TipoIngressoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/evento/{eventoId}")
    public ResponseEntity<List<TipoIngressoResponseDTO>> listarPorEvento(@PathVariable Long eventoId) {
        return ResponseEntity.ok(service.listarPorEvento(eventoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
