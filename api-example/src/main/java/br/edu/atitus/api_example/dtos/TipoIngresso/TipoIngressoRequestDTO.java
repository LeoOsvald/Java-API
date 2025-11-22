package br.edu.atitus.api_example.dtos.TipoIngresso;

public class TipoIngressoRequestDTO {
    private String nome;
    private Double preco;
    private Integer estoque;
    private Long eventoId;

    public TipoIngressoRequestDTO() {
    }

    public TipoIngressoRequestDTO(String nome, Double preco, Integer estoque, Long eventoId) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.eventoId = eventoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }
}
