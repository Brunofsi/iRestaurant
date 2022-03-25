package br.com.iRestaurant.api.usuario.cadastra_dono.dto;

import br.com.iRestaurant.api.usuario.Dono;
import br.com.iRestaurant.api.usuario.cadastra_dono.validador.ValidadorCadastroDonoRequest;
import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

import java.util.List;

public class CadastroDonoRequest {
    private String email;
    private String senha;
    private String confirmaSenha;

    public CadastroDonoRequest(String email, String senha, String confirmaSenha) {
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
    }

    public List<Erro> valida(ValidadorCadastroDonoRequest validador){
        return validador.valida(this.email, this.senha, this.confirmaSenha);
    }

    public Dono paraDono(){
        return new Dono(this.email, this.senha);
    }
}
