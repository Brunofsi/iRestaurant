package br.com.iRestaurant.core.exception.dto.impl;

import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ErroApiEntidadeNaoEncontrada extends ErroApi {
    public ErroApiEntidadeNaoEncontrada(String titulo, String mensagemUsuario, List<Erro> erros) {
        super(titulo, mensagemUsuario, erros);
    }

    @Override
    public ResponseEntity<ErroApi> converteParaHttp() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this);
    }
}
