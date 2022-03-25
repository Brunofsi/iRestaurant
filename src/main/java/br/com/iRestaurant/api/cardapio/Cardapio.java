package br.com.iRestaurant.api.cardapio;


import br.com.iRestaurant.api.restaurante.Restaurante;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Cardapio {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "cardapio")
    private Set<CategoriaCardapio> categorias;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Restaurante restaurante;

    @Deprecated public Cardapio() {}

    public Cardapio(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public UUID getId() {
        return id;
    }

    public Set<CategoriaCardapio> getCategorias() {
        return categorias;
    }

    public Restaurante getLoja() {
        return restaurante;
    }
}
