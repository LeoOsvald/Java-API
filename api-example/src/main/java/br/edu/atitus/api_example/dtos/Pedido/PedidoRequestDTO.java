package br.edu.atitus.api_example.dtos.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class PedidoRequestDTO {
    private UUID compradorId;
    private LocalDateTime dataCompra;
    private Double total;
    private List<Long> ingressosIds;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(UUID compradorId, LocalDateTime dataCompra, Double total, List<Long> ingressosIds) {
        this.compradorId = compradorId;
        this.dataCompra = dataCompra;
        this.total = total;
        this.ingressosIds = ingressosIds;
    }

    public UUID getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(UUID compradorId) {
        this.compradorId = compradorId;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Long> getIngressosIds() {
        return ingressosIds;
    }

    public void setIngressosIds(List<Long> ingressosIds) {
        this.ingressosIds = ingressosIds;
    }
}
