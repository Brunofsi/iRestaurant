package br.com.iRestaurant.api.restaurante;

import br.com.iRestaurant.api.cardapio.Cardapio;
import br.com.iRestaurant.api.pedido.Pedido;
import br.com.iRestaurant.api.usuario.Dono;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Restaurante {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(unique = true)
    private String cnpj;

    private String telefone;

    private String nome;

    private TipoLoja tipo;

    @OneToMany(mappedBy = "restaurante")
    private Set<Pedido> pedidos;

    @ManyToOne(optional = false)
    private Dono dono;

    @OneToOne(mappedBy = "restaurante", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Cardapio cardapio;

    @Deprecated // hibernate use only
    public Restaurante() {}

    public Restaurante(UUID id, String cnpj, String telefone, String nome, Cardapio cardapio) {
        this.id = id;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.cardapio = cardapio;
        this.nome = nome;
    }

    public Restaurante(String cnpj, String telefone, String nome, Dono dono) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nome = nome;
        this.dono = dono;
        this.cardapio = new Cardapio(this);
        this.tipo = TipoLoja.ALIMENTAR;
    }

    public UUID getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public String getNome() { return nome; }

    public TipoLoja getTipo() {
        return tipo;
    }

    public Cardapio getCatalogo() {
        return cardapio;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public Dono getDono() {
        return dono;
    }

    public enum TipoLoja{
        ALIMENTAR, ROUPA
    }
}
