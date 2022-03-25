package br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.usecase;

import br.com.iRestaurant.api.restaurante.Restaurante;
import br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.dto.ConsultaRestaurantePorUUIDResponse;
import br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.validador.ValidadorConsultaRestaurantePorUUIDRequest;

import br.com.iRestaurant.core.exception.dto.ErroApi;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiEntidadeNaoEncontrada;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiMensagemInvalida;
import br.com.iRestaurant.api.restaurante.RestauranteRepositorio;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ConsultaRestaurantePorUUIDUseCaseImpl implements IConsultaRestaurantePorUUIDUseCase {

    private RestauranteRepositorio restauranteRepositorio;
    private ValidadorConsultaRestaurantePorUUIDRequest validador;

    public ConsultaRestaurantePorUUIDUseCaseImpl(RestauranteRepositorio restauranteRepositorio, ValidadorConsultaRestaurantePorUUIDRequest validador){
        this.restauranteRepositorio = restauranteRepositorio;
        this.validador = validador;
    }

    @Override
    public Either<ErroApi, ConsultaRestaurantePorUUIDResponse> consultaRestaurantePorUUID(String uuid) {
        List<ErroApi.Erro> erros = validador.valida(uuid);
        if( ! erros.isEmpty() ) return Either.left(new ErroApiMensagemInvalida("Mensagem Invalida", "Um ou mais propriedades estão inválidas, por for corrija-as.", erros));
        Optional<Restaurante> restaurante = restauranteRepositorio.findById(UUID.fromString(uuid));
        if(restaurante.isEmpty()) return Either.left(new ErroApiEntidadeNaoEncontrada("Loja nao encontrada", "Nao foi encontrado uma loja com UUID " + uuid, List.of()));
        return Either.right(new ConsultaRestaurantePorUUIDResponse(restaurante.get()));
    }
}
