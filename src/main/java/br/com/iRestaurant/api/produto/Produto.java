package br.com.iRestaurant.api.produto;

import br.com.iRestaurant.api.cardapio.CategoriaCardapio;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
public class Produto {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String nome;
    private String descricao;

    private BigDecimal precoInicial;

    @ManyToOne
    private CategoriaCardapio categoriaCardapio;

    @OneToMany(mappedBy = "produto")
    private Set<GrupoOpcaoProduto> gruposOpcoesProduto;

    @Deprecated public Produto() {}

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoInicial() {
        return precoInicial;
    }

    public CategoriaCardapio getCategoriaCatalogo() {
        return categoriaCardapio;
    }

    public Set<GrupoOpcaoProduto> getGruposOpcoesProduto() {
        return gruposOpcoesProduto;
    }
}
