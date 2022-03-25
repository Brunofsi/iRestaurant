package br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid;

import br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.usecase.IConsultaRestaurantePorUUIDUseCase;
import br.com.iRestaurant.api.restaurante.consulta_restaurante_por_uuid.dto.ConsultaRestaurantePorUUIDResponse;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ConsultaRestaurantePorUUIDController {

    private IConsultaRestaurantePorUUIDUseCase consultador;

    public ConsultaRestaurantePorUUIDController(IConsultaRestaurantePorUUIDUseCase consultador){
        this.consultador = consultador;
    }

    @GetMapping("/restaurantes/{uuid}")
    public ResponseEntity<?> consulta(@PathVariable String uuid){
        Either<ErroApi, ConsultaRestaurantePorUUIDResponse> resultado = consultador.consultaRestaurantePorUUID(uuid);
        return resultado.fold(
                ErroApi::converteParaHttp,
                ResponseEntity::ok
        );
    }


}
