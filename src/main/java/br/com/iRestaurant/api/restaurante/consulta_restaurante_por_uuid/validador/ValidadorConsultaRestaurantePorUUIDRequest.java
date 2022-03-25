package br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.validador;

import br.com.iRestaurant.core.validation.ValidadorUUID;
import org.springframework.stereotype.Component;
import static br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidadorConsultaRestaurantePorUUIDRequest {
    private ValidadorUUID validadorUUID;


    public ValidadorConsultaRestaurantePorUUIDRequest(ValidadorUUID validadorUUID){
        this.validadorUUID = validadorUUID;
    }

    public List<Erro> valida(String uuid){
        List<Erro> erros = new ArrayList<>();
        boolean uuidNaoEhValido = !validadorUUID.valida(uuid);
        if( uuidNaoEhValido ) erros.add(new Erro("uuid", "O path parameter uuid não esta em um formato UUID valido."));
        return erros;
    }

}
