package br.com.iRestaurant.api.feedback;


import br.com.iRestaurant.api.pedido.Pedido;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Feedback {
    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Pedido pedido;

    @Enumerated(EnumType.ORDINAL)
    private NotaFeedback nota;
    private String descricao;

    // ORM purpose only
    @Deprecated  public Feedback() {}

    public Feedback(Pedido pedido, NotaFeedback nota, String descricao) {
        this.pedido = pedido;
        this.nota = nota;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public NotaFeedback getNota() {
        return nota;
    }

    public String getDescricao() {
        return descricao;
    }
}
