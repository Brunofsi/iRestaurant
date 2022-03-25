package br.com.iRestaurant.api.usuario.cadastra_dono.usecase;

import br.com.iRestaurant.api.usuario.Dono;
import br.com.iRestaurant.api.usuario.DonoRepository;
import br.com.iRestaurant.api.usuario.cadastra_dono.dto.CadastroDonoRequest;
import br.com.iRestaurant.api.usuario.cadastra_dono.dto.CadastroDonoResponse;
import br.com.iRestaurant.api.usuario.cadastra_dono.validador.ValidadorCadastroDonoRequest;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiMensagemInvalida;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CadastraDonoUseCase implements ICadastraDonoUseCase{

    private final DonoRepository repositorioDono;
    private final ValidadorCadastroDonoRequest validadorRequest;

    public CadastraDonoUseCase(DonoRepository repositorioDono, ValidadorCadastroDonoRequest validadorRequest) {
        this.repositorioDono = repositorioDono;
        this.validadorRequest = validadorRequest;
    }

    @Override
    public Either<ErroApi, CadastroDonoResponse> executa(CadastroDonoRequest request) {
        List<Erro> erros = request.valida(validadorRequest);
        if(! erros.isEmpty()) return Either.left(new ErroApiMensagemInvalida("Mensagem Invalida", "Um ou mais propriedades estão inválidas, por for corrija-as.", erros));
        Dono dono = request.paraDono();
        Dono donoCadastrado = repositorioDono.save(dono);
        return Either.right(new CadastroDonoResponse(donoCadastrado));
    }
}
