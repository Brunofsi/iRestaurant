package br.com.iRestaurant.api.usuario.cadastra_dono.usecase;

import br.com.iRestaurant.api.usuario.cadastra_dono.dto.CadastroDonoRequest;
import br.com.iRestaurant.api.usuario.cadastra_dono.dto.CadastroDonoResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;

public interface ICadastraDonoUseCase {
    Either<ErroApi, CadastroDonoResponse> executa(CadastroDonoRequest request);
}
