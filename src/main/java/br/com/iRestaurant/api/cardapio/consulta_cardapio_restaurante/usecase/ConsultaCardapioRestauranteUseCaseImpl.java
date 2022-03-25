package br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.usecase;

import br.com.iRestaurant.api.cardapio.Cardapio;
import br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.dto.ConsultaCardapioRestauranteResponse;
import br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.validador.ValidadorConsultaCardapioRestauranteRequest;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiEntidadeNaoEncontrada;
import br.com.iRestaurant.core.exception.dto.impl.ErroApiMensagemInvalida;
import br.com.iRestaurant.api.cardapio.RepositorioCardapio;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

@Component
public class ConsultaCardapioRestauranteUseCaseImpl implements IConsultaCardapioRestauranteUseCase {

    private RepositorioCardapio repositorioCardapio;
    private ValidadorConsultaCardapioRestauranteRequest validador;

    public ConsultaCardapioRestauranteUseCaseImpl(RepositorioCardapio repositorioCardapio, ValidadorConsultaCardapioRestauranteRequest validador){
        this.repositorioCardapio = repositorioCardapio;
        this.validador = validador;
    }

    @Override
    public Either<ErroApi, ConsultaCardapioRestauranteResponse> consultaCardapioRestaurante(String uuidLoja) {
        List<Erro> erros = validador.valida(uuidLoja);
        if( ! erros.isEmpty() ) return Either.left(new ErroApiMensagemInvalida("Mensagem Invalida", "Um ou mais propriedades estão inválidas, por for corrija-as.", erros));
        Optional<Cardapio> catalogoLoja = repositorioCardapio.findById(UUID.fromString(uuidLoja));
        if(catalogoLoja.isEmpty()) return Either.left(new ErroApiEntidadeNaoEncontrada("Catalogo loja nao encontrado", "Nao foi encontrado um catalogo loja com UUID " + uuidLoja, List.of()));
        return Either.right(new ConsultaCardapioRestauranteResponse(catalogoLoja.get()));
    }
}
