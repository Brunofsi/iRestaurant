package br.com.iRestaurant.api.restaurante.cadastra_restaurante;

import br.com.iRestaurant.api.restaurante.cadastra_restaurante.usecase.ICadastraRestauranteUseCase;
import br.com.iRestaurant.api.restaurante.cadastra_restaurante.dto.CadastroRestauranteRequest;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/api/v1")
public class CadastraRestauranteController {

    private ICadastraRestauranteUseCase cadastrador;

    public CadastraRestauranteController(ICadastraRestauranteUseCase cadastrador){
        this.cadastrador = cadastrador;
    }

    @PostMapping("donos/{idDono}/restaurantes")
    public ResponseEntity<?> cadastra(@PathVariable("idDono") UUID idDono, @RequestBody CadastroRestauranteRequest request){
        return cadastrador.executa(request.adicionaIdDono(idDono)).fold(
                ErroApi::converteParaHttp,
                ResponseEntity::ok
        );
    }
}
