package br.edu.atitus.api_example.dtos.Ingresso;

public class IngressoResponseDTO {
    private Long id;
    private Long tipoIngressoId;
    private String tipoIngressoNome;
    private Long pedidoId;
    private String codigoQr;

    public IngressoResponseDTO() {
    }

    public IngressoResponseDTO(Long id, Long tipoIngressoId, String tipoIngressoNome, Long pedidoId, String codigoQr) {
        this.id = id;
        this.tipoIngressoId = tipoIngressoId;
        this.tipoIngressoNome = tipoIngressoNome;
        this.pedidoId = pedidoId;
        this.codigoQr = codigoQr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoIngressoId() {
        return tipoIngressoId;
    }

    public void setTipoIngressoId(Long tipoIngressoId) {
        this.tipoIngressoId = tipoIngressoId;
    }

    public String getTipoIngressoNome() {
        return tipoIngressoNome;
    }

    public void setTipoIngressoNome(String tipoIngressoNome) {
        this.tipoIngressoNome = tipoIngressoNome;
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
