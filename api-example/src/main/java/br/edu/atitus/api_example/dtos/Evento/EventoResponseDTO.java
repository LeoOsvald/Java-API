package br.edu.atitus.api_example.dtos.Evento;

import java.time.LocalDate;

public record EventoResponseDTO(
        Long id,
        String titulo,
        String descricao,
        LocalDate data
) {}
