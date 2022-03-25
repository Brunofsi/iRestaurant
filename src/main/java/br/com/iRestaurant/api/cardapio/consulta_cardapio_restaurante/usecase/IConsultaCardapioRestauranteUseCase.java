package br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.usecase;

import br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.dto.ConsultaCardapioRestauranteResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;

public interface IConsultaCardapioRestauranteUseCase {
    Either<ErroApi, ConsultaCardapioRestauranteResponse> consultaCardapioRestaurante(String uuidLoja);
}
