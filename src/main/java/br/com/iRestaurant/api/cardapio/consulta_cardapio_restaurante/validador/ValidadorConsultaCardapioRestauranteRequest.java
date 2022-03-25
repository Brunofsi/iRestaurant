package br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.validador;

import br.com.iRestaurant.core.validation.ValidadorUUID;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

@Component
public class ValidadorConsultaCardapioRestauranteRequest {
    private final ValidadorUUID validadorUUID;

    public ValidadorConsultaCardapioRestauranteRequest(ValidadorUUID validadorUUID){
        this.validadorUUID = validadorUUID;
    }

    public List<Erro> valida(String uuid){
        List<Erro> erros = new ArrayList<>();
        boolean uuidNaoEhValido = !validadorUUID.valida(uuid);
        if( uuidNaoEhValido ) erros.add(new Erro("uuid", "O path parameter uuid não esta em um formato UUID valido."));
        return erros;
    }

}
