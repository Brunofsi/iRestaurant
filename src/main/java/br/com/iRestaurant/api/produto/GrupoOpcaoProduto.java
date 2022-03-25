package br.com.iRestaurant.api.produto;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class GrupoOpcaoProduto {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String nome;
    private String descricao;

    @ManyToOne
    private Produto produto;

    @OneToMany(mappedBy = "grupoOpcaoProduto")
    private Set<OpcaoProduto> opcoesProdutos;

    @Deprecated public GrupoOpcaoProduto() {}

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public Set<OpcaoProduto> getOpcoesProdutos() {
        return opcoesProdutos;
    }
}
