package br.edu.atitus.api_example.dtos.TipoIngresso;

public class TipoIngressoResponseDTO {
    private Long id;
    private String nome;
    private Double preco;
    private Integer estoque;
    private Long eventoId;
    private String eventoTitulo;

    public TipoIngressoResponseDTO() {
    }

    public TipoIngressoResponseDTO(Long id, String nome, Double preco, Integer estoque, Long eventoId, String eventoTitulo) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.eventoId = eventoId;
        this.eventoTitulo = eventoTitulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEventoTitulo() {
        return eventoTitulo;
    }

    public void setEventoTitulo(String eventoTitulo) {
        this.eventoTitulo = eventoTitulo;
    }
}
