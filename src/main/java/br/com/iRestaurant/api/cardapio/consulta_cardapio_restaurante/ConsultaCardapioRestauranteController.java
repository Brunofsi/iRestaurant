package br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante;

import br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.usecase.IConsultaCardapioRestauranteUseCase;
import br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.dto.ConsultaCardapioRestauranteResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ConsultaCardapioRestauranteController {

    private IConsultaCardapioRestauranteUseCase consultador;

    public ConsultaCardapioRestauranteController(IConsultaCardapioRestauranteUseCase consultador){
        this.consultador = consultador;
    }

    @GetMapping("/restaurantes/{uuid}/cardapio")
    public ResponseEntity<?> consulta(@PathVariable String uuid){
        Either<ErroApi, ConsultaCardapioRestauranteResponse> resultado = consultador.consultaCardapioRestaurante(uuid);
        return resultado.fold(
                ErroApi::converteParaHttp,
                ResponseEntity::ok
        );
    }


}
