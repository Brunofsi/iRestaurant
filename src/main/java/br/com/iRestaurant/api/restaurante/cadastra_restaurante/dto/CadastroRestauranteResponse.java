package br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto;

import br.com.iRestaurant.api.restaurante.Restaurante;

import java.util.UUID;

public class CadastroRestauranteResponse {
    private UUID id;
    private String cnpj;
    private String telefone;
    private String nome;

    public CadastroRestauranteResponse(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.cnpj = restaurante.getCnpj();
        this.telefone = restaurante.getTelefone();
        this.nome = restaurante.getNome();
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

    public String getNome() { return nome; }
}
