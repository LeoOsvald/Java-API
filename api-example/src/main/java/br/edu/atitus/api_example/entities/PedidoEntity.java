package br.edu.atitus.api_example.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comprador_id", nullable = false)
    private UsuarioEntity comprador;

    private LocalDateTime dataCompra;
    private Double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Ingresso> ingressos;

    //#region Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getComprador() {
        return comprador;
    }

    public void setComprador(UsuarioEntity comprador) {
        this.comprador = comprador;
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

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    //#endregion

}