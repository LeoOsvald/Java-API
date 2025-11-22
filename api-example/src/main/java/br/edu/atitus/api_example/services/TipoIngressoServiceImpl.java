package br.edu.atitus.api_example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoRequestDTO;
import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoResponseDTO;
import br.edu.atitus.api_example.entities.EventoEntity;
import br.edu.atitus.api_example.entities.TipoIngressoEntity;
import br.edu.atitus.api_example.repositories.EventoRepository;
import br.edu.atitus.api_example.repositories.TipoIngressoRepository;

@Service
public class TipoIngressoServiceImpl implements TipoIngressoService {

    private final TipoIngressoRepository repository;
    private final EventoRepository eventoRepository;

    public TipoIngressoServiceImpl(TipoIngressoRepository repository, EventoRepository eventoRepository) {
        this.repository = repository;
        this.eventoRepository = eventoRepository;
    }

    @Transactional
    @Override
    public TipoIngressoResponseDTO criar(TipoIngressoRequestDTO dto) {
        TipoIngressoEntity entity = new TipoIngressoEntity();
        
        EventoEntity evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        
        entity.setNome(dto.getNome());
        entity.setPreco(dto.getPreco());
        entity.setEstoque(dto.getEstoque());
        entity.setEvento(evento);

        TipoIngressoEntity salvo = repository.save(entity);

        return new TipoIngressoResponseDTO(
                salvo.getId(),
                salvo.getNome(),
                salvo.getPreco(),
                salvo.getEstoque(),
                salvo.getEvento().getId(),
                salvo.getEvento().getTitulo()
        );
    }

    @Transactional
    @Override
    public TipoIngressoResponseDTO atualizar(Long id, TipoIngressoRequestDTO dto) {
        TipoIngressoEntity existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de ingresso não encontrado"));

        EventoEntity evento = eventoRepository.findById(dto.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        existente.setNome(dto.getNome());
        existente.setPreco(dto.getPreco());
        existente.setEstoque(dto.getEstoque());
        existente.setEvento(evento);

        TipoIngressoEntity atualizado = repository.save(existente);

        return new TipoIngressoResponseDTO(
                atualizado.getId(),
                atualizado.getNome(),
                atualizado.getPreco(),
                atualizado.getEstoque(),
                atualizado.getEvento().getId(),
                atualizado.getEvento().getTitulo()
        );
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public TipoIngressoResponseDTO buscarPorId(Long id) {
        TipoIngressoEntity encontrado = repository.findById(id)
                .orElse(null);

        if (encontrado == null)
            return null;

        return new TipoIngressoResponseDTO(
                encontrado.getId(),
                encontrado.getNome(),
                encontrado.getPreco(),
                encontrado.getEstoque(),
                encontrado.getEvento().getId(),
                encontrado.getEvento().getTitulo()
        );
    }

    @Override
    public TipoIngressoResponseDTO buscarPorNome(String nome) {
        TipoIngressoEntity encontrado = repository.findByNome(nome)
                .orElse(null);

        if (encontrado == null)
            return null;

        return new TipoIngressoResponseDTO(
                encontrado.getId(),
                encontrado.getNome(),
                encontrado.getPreco(),
                encontrado.getEstoque(),
                encontrado.getEvento().getId(),
                encontrado.getEvento().getTitulo()
        );
    }

    @Override
    public List<TipoIngressoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(t -> new TipoIngressoResponseDTO(
                        t.getId(),
                        t.getNome(),
                        t.getPreco(),
                        t.getEstoque(),
                        t.getEvento().getId(),
                        t.getEvento().getTitulo()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoIngressoResponseDTO> listarPorEvento(Long eventoId) {
        return repository.findByEventoId(eventoId)
                .stream()
                .map(t -> new TipoIngressoResponseDTO(
                        t.getId(),
                        t.getNome(),
                        t.getPreco(),
                        t.getEstoque(),
                        t.getEvento().getId(),
                        t.getEvento().getTitulo()
                ))
                .collect(Collectors.toList());
    }
}
