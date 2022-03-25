package br.com.iRestaurant.api.restaurante.cadastra_restaurante.usecase;

import br.com.iRestaurant.api.restaurante.Restaurante;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto.CadastroRestauranteRequest;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto.CadastroRestauranteResponse;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.validador.ValidadorCadastroLojaRequest;
import br.com.iRestaurant.api.usuario.Dono;
import br.com.iRestaurant.api.usuario.DonoRepository;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiEntidadeConflituante;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiEntidadeNaoProcessavel;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiMensagemInvalida;
import br.com.iRestaurant.api.restaurante.RestauranteRepositorio;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CadastraRestauranteUseCaseImpl implements ICadastraRestauranteUseCase {

    private ValidadorCadastroLojaRequest validador;
    private RestauranteRepositorio restauranteRepositorio;
    private DonoRepository donoRepositorio;

    public CadastraRestauranteUseCaseImpl(ValidadorCadastroLojaRequest validador,
                                          RestauranteRepositorio restauranteRepositorio,
                                          DonoRepository donoRepositorio) {
        this.restauranteRepositorio = restauranteRepositorio;
        this.validador = validador;
        this.donoRepositorio = donoRepositorio;
    }

    @Override
    public Either<ErroApi, CadastroRestauranteResponse> executa(CadastroRestauranteRequest request) {
        List<ErroApi.Erro> erros = request.valida(validador);
        if(! erros.isEmpty()) return Either.left(new ErroApiMensagemInvalida("Mensagem Invalida", "Um ou mais propriedades estão inválidas, por for corrija-as.", erros)); // valida mensagem - 400
        Optional<Dono> donoRestaurante = donoRepositorio.findById(request.getIdDono());
        if(donoRestaurante.isEmpty()) return Either.left(new ErroApiEntidadeNaoProcessavel("Restaurante nao cadastravel", "Nao foi encontrado nenhum dono com o id mencionado", List.of()));
        if(restauranteRepositorio.existsByCnpj(request.getCnpj())) return Either.left(new ErroApiEntidadeConflituante("Restaurante conflituante", "Já existe em nossa base um restaurante atrelado ao CNPJ mencionado.", List.of()));
        Restaurante restauranteSalvo = restauranteRepositorio.save(request.paraRestaurante(donoRestaurante.get()));
        return Either.right(new CadastroRestauranteResponse(restauranteSalvo));
    }
}
