package br.edu.atitus.api_example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ingressos")
public class Ingresso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_ingresso_id", nullable = false)
    private TipoIngressoEntity tipo;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoEntity pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoIngressoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngressoEntity tipo) {
        this.tipo = tipo;
    }

    public PedidoEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoEntity pedido) {
        this.pedido = pedido;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    private String codigoQr; // string gerada (UUID, base64, etc)

    // getters e setters
}