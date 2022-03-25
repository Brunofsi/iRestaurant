package br.com.iRestaurant.api.usuario.cadastra_dono;

import br.com.iRestaurant.api.usuario.cadastra_dono.dto.CadastroDonoRequest;
import br.com.iRestaurant.api.usuario.cadastra_dono.usecase.ICadastraDonoUseCase;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1")
public class CadastraDonoController {

    private ICadastraDonoUseCase cadastrador;

    public CadastraDonoController(ICadastraDonoUseCase cadastrador){
        this.cadastrador = cadastrador;
    }

    @PostMapping("/donos")
    public ResponseEntity<?> cadastra(@RequestBody CadastroDonoRequest request){
        return cadastrador.executa(request).fold(
                ErroApi::converteParaHttp,
                ResponseEntity::ok
        );
    }
}
