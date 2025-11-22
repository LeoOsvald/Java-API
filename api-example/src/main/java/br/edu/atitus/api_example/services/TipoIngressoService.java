package br.edu.atitus.api_example.services;

import java.util.List;

import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoRequestDTO;
import br.edu.atitus.api_example.dtos.TipoIngresso.TipoIngressoResponseDTO;

public interface TipoIngressoService {

    TipoIngressoResponseDTO criar(TipoIngressoRequestDTO novo);

    TipoIngressoResponseDTO atualizar(Long id, TipoIngressoRequestDTO tipoIngresso);

    void deletar(Long id);

    TipoIngressoResponseDTO buscarPorId(Long id);

    TipoIngressoResponseDTO buscarPorNome(String nome);

    List<TipoIngressoResponseDTO> listarTodos();
    
    List<TipoIngressoResponseDTO> listarPorEvento(Long eventoId);
}
