package br.edu.atitus.api_example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.atitus.api_example.entities.TipoIngressoEntity;

public interface TipoIngressoRepository extends JpaRepository<TipoIngressoEntity, Long> {
    
    Optional<TipoIngressoEntity> findById(Long id);
    
    List<TipoIngressoEntity> findByEventoId(Long eventoId);
    
    Optional<TipoIngressoEntity> findByNome(String nome);
    
    void deleteById(Long id);
}
