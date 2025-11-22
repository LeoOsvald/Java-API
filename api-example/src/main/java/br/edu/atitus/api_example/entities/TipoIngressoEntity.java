package br.edu.atitus.api_example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_ingresso")
public class TipoIngressoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome; // VIP, PISTA, etc
    private Double preco;
    private Integer estoque;

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

    public EventoEntity getEvento() {
        return evento;
    }

    public void setEvento(EventoEntity evento) {
        this.evento = evento;
    }

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private EventoEntity evento;

    // getters e setters
}
