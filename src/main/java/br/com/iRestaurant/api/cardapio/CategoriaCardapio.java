package br.com.iRestaurant.api.cardapio;

import br.com.iRestaurant.api.produto.Produto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class CategoriaCardapio {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne
    private Cardapio cardapio;

    private String nome;

    @OneToMany(mappedBy = "categoriaCardapio")
    private Set<Produto> produtos;

    @Deprecated public CategoriaCardapio() {}

    public UUID getId() {
        return id;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public String getNome() {
        return nome;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }
}
