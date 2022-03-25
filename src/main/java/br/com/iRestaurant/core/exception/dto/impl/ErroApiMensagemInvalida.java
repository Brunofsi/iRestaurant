package br.com.iRestaurant.core.exception.dto.impl;

import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ErroApiMensagemInvalida extends ErroApi {
    public ErroApiMensagemInvalida(String titulo, String mensagemUsuario, List<Erro> erros) {
        super(titulo, mensagemUsuario, erros);
    }

    @Override
    public ResponseEntity<ErroApi> converteParaHttp() {
        return ResponseEntity.badRequest().body(this);
    }
}
