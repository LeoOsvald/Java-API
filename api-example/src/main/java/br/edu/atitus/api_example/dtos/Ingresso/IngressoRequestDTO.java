package br.edu.atitus.api_example.dtos.Ingresso;

public class IngressoRequestDTO {
    private Long tipoIngressoId;
    private Long pedidoId;
    private String codigoQr;

    public IngressoRequestDTO() {
    }

    public IngressoRequestDTO(Long tipoIngressoId, Long pedidoId, String codigoQr) {
        this.tipoIngressoId = tipoIngressoId;
        this.pedidoId = pedidoId;
        this.codigoQr = codigoQr;
    }

    public Long getTipoIngressoId() {
        return tipoIngressoId;
    }

    public void setTipoIngressoId(Long tipoIngressoId) {
        this.tipoIngressoId = tipoIngressoId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }
}
