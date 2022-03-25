package br.com.iRestaurant.api.produto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class OpcaoProduto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private BigDecimal preco;

    private String nome;

    private String descricao;

    @ManyToOne
    private GrupoOpcaoProduto grupoOpcaoProduto;

    @Deprecated
    public OpcaoProduto() {}

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public GrupoOpcaoProduto getGrupoOpcaoProduto() {
        return grupoOpcaoProduto;
    }
}
