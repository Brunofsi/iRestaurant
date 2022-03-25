package br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto;

import br.com.iRestaurant.api.restaurante.Restaurante;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.validador.ValidadorCadastroLojaRequest;
import br.com.iRestaurant.api.usuario.Dono;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;
import java.util.UUID;

public class CadastroRestauranteRequest {
    private String cnpj;
    private String telefone;
    private String nome;
    private UUID idDono;

    @JsonCreator
    public CadastroRestauranteRequest(String cnpj, String telefone, String nome) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nome = nome;
    }

    public CadastroRestauranteRequest(String cnpj, String telefone, String nome, UUID idDono) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.nome = nome;
        this.idDono = idDono;
    }

    public List<ErroApi.Erro> valida(ValidadorCadastroLojaRequest validador){
        return validador.valida(this.cnpj, this.telefone);
    }

    public CadastroRestauranteRequest adicionaIdDono(UUID idDono){
        return new CadastroRestauranteRequest(this.cnpj, this.telefone, this.nome, idDono);
    }

    public Restaurante paraRestaurante(Dono dono){
        return new Restaurante(this.cnpj, this.telefone, this.nome, dono);
    }

    public String getCnpj(){return this.cnpj; };

    public UUID getIdDono() {
        return idDono;
    }
}
