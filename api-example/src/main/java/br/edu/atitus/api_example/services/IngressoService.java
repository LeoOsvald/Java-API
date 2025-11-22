package br.edu.atitus.api_example.services;

import java.util.List;

import br.edu.atitus.api_example.dtos.Ingresso.IngressoRequestDTO;
import br.edu.atitus.api_example.dtos.Ingresso.IngressoResponseDTO;

public interface IngressoService {

    IngressoResponseDTO criar(IngressoRequestDTO novo);

    IngressoResponseDTO atualizar(Long id, IngressoRequestDTO ingresso);

    void deletar(Long id);

    IngressoResponseDTO buscarPorId(Long id);

    IngressoResponseDTO buscarPorCodigoQr(String codigoQr);

    List<IngressoResponseDTO> listarTodos();
    
    List<IngressoResponseDTO> listarPorPedido(Long pedidoId);
}
