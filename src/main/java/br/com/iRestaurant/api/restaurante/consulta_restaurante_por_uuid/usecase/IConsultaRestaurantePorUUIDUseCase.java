package br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.usecase;

import br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.dto.ConsultaRestaurantePorUUIDResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;

public interface IConsultaRestaurantePorUUIDUseCase {
    Either<ErroApi, ConsultaRestaurantePorUUIDResponse> consultaRestaurantePorUUID(String uuid);
}
