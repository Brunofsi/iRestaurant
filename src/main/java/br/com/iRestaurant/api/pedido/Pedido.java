package br.com.iRestaurant.api.pedido;

import br.com.iRestaurant.api.feedback.Feedback;
import br.com.iRestaurant.api.restaurante.Restaurante;
import br.com.iRestaurant.api.usuario.Cliente;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @OneToMany(mappedBy = "pedido")
    private Set<ItemPedido> itensPedido;

    @ManyToOne
    private Restaurante restaurante;

    @ManyToOne
    private Cliente cliente;

    @OneToOne(optional = true)
    private Feedback feedbackCliente;

    private LocalDateTime dataCriacao;

    private BigDecimal valorSubTotal;
    private BigDecimal valorFrete;
    private BigDecimal valorTotal;

    @Deprecated public Pedido() {}

    public UUID getId() {
        return id;
    }

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Feedback getFeedbackCliente() {
        return feedbackCliente;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public BigDecimal getValorSubTotal() {
        return valorSubTotal;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }
}
