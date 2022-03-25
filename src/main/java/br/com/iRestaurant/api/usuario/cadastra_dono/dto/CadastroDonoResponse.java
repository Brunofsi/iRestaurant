package br.com.iRestaurant.api.usuario.cadastra_dono.dto;


import br.com.iRestaurant.api.usuario.Dono;

import java.util.UUID;

public class CadastroDonoResponse {

    private UUID id;
    private String email;

    public CadastroDonoResponse(Dono dono){
        this.id = dono.getId();
        this.email = dono.getEmail();
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
