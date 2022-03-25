package br.com.iRestaurant.api.restaurante.cadastra_restaurante.usecase;

import br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto.CadastroRestauranteRequest;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto.CadastroRestauranteResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;

public interface ICadastraRestauranteUseCase {
    Either<ErroApi, CadastroRestauranteResponse> executa(CadastroRestauranteRequest request);
}
