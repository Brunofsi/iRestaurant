package br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.dto;

import br.com.iRestaurant.api.restaurante.Restaurante;

import java.util.UUID;

public class ConsultaRestaurantePorUUIDResponse {

    private UUID id;
    private String nome;
    private String cnpj;
    private String telefone;

    public ConsultaRestaurantePorUUIDResponse(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.cnpj = restaurante.getCnpj();
        this.telefone = restaurante.getTelefone();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }
}
