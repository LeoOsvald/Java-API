package br.edu.atitus.api_example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.atitus.api_example.dtos.Ingresso.IngressoRequestDTO;
import br.edu.atitus.api_example.dtos.Ingresso.IngressoResponseDTO;
import br.edu.atitus.api_example.entities.Ingresso;
import br.edu.atitus.api_example.entities.PedidoEntity;
import br.edu.atitus.api_example.entities.TipoIngressoEntity;
import br.edu.atitus.api_example.repositories.IngressoRepository;
import br.edu.atitus.api_example.repositories.PedidoRepository;
import br.edu.atitus.api_example.repositories.TipoIngressoRepository;

@Service
public class IngressoServiceImpl implements IngressoService {

    private final IngressoRepository repository;
    private final TipoIngressoRepository tipoIngressoRepository;
    private final PedidoRepository pedidoRepository;

    public IngressoServiceImpl(IngressoRepository repository, 
                               TipoIngressoRepository tipoIngressoRepository,
                               PedidoRepository pedidoRepository) {
        this.repository = repository;
        this.tipoIngressoRepository = tipoIngressoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    @Override
    public IngressoResponseDTO criar(IngressoRequestDTO dto) {
        Ingresso entity = new Ingresso();
        
        TipoIngressoEntity tipo = tipoIngressoRepository.findById(dto.getTipoIngressoId())
                .orElseThrow(() -> new RuntimeException("Tipo de ingresso não encontrado"));
        
        PedidoEntity pedido = pedidoRepository.findById(dto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        
        entity.setTipo(tipo);
        entity.setPedido(pedido);
        entity.setCodigoQr(dto.getCodigoQr());

        Ingresso salvo = repository.save(entity);

        return new IngressoResponseDTO(
                salvo.getId(),
                salvo.getTipo().getId(),
                salvo.getTipo().getNome(),
                salvo.getPedido().getId(),
                salvo.getCodigoQr()
        );
    }

    @Transactional
    @Override
    public IngressoResponseDTO atualizar(Long id, IngressoRequestDTO dto) {
        Ingresso existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingresso não encontrado"));

        TipoIngressoEntity tipo = tipoIngressoRepository.findById(dto.getTipoIngressoId())
                .orElseThrow(() -> new RuntimeException("Tipo de ingresso não encontrado"));
        
        PedidoEntity pedido = pedidoRepository.findById(dto.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        existente.setTipo(tipo);
        existente.setPedido(pedido);
        existente.setCodigoQr(dto.getCodigoQr());

        Ingresso atualizado = repository.save(existente);

        return new IngressoResponseDTO(
                atualizado.getId(),
                atualizado.getTipo().getId(),
                atualizado.getTipo().getNome(),
                atualizado.getPedido().getId(),
                atualizado.getCodigoQr()
        );
    }

    @Transactional
    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public IngressoResponseDTO buscarPorId(Long id) {
        Ingresso encontrado = repository.findById(id)
                .orElse(null);

        if (encontrado == null)
            return null;

        return new IngressoResponseDTO(
                encontrado.getId(),
                encontrado.getTipo().getId(),
                encontrado.getTipo().getNome(),
                encontrado.getPedido().getId(),
                encontrado.getCodigoQr()
        );
    }

    @Override
    public IngressoResponseDTO buscarPorCodigoQr(String codigoQr) {
        Ingresso encontrado = repository.findByCodigoQr(codigoQr)
                .orElse(null);

        if (encontrado == null)
            return null;

        return new IngressoResponseDTO(
                encontrado.getId(),
                encontrado.getTipo().getId(),
                encontrado.getTipo().getNome(),
                encontrado.getPedido().getId(),
                encontrado.getCodigoQr()
        );
    }

    @Override
    public List<IngressoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(i -> new IngressoResponseDTO(
                        i.getId(),
                        i.getTipo().getId(),
                        i.getTipo().getNome(),
                        i.getPedido().getId(),
                        i.getCodigoQr()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<IngressoResponseDTO> listarPorPedido(Long pedidoId) {
        return repository.findByPedidoId(pedidoId)
                .stream()
                .map(i -> new IngressoResponseDTO(
                        i.getId(),
                        i.getTipo().getId(),
                        i.getTipo().getNome(),
                        i.getPedido().getId(),
                        i.getCodigoQr()
                ))
                .collect(Collectors.toList());
    }
}
