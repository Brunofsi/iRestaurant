package br.com.iRestaurant.api.usuario;

import br.com.iRestaurant.api.restaurante.Restaurante;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Dono{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String email;
    private String senha;

    @OneToMany(mappedBy = "dono")
    private Set<Restaurante> restaurantes;

    @Deprecated public Dono() {}

    public Dono(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.restaurantes = new HashSet<>();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Set<Restaurante> getRestaurantes() {
        return restaurantes;
    }
}
