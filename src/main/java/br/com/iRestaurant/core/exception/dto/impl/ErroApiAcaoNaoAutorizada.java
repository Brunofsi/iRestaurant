package br.com.iRestaurant.core.exception.dto.impl;

import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ErroApiAcaoNaoAutorizada extends ErroApi {
    public ErroApiAcaoNaoAutorizada(String titulo, String mensagemUsuario, List<Erro> erros) {
        super(titulo, mensagemUsuario, erros);
    }

    @Override
    public ResponseEntity<ErroApi> converteParaHttp() {
        return null;
    }
}
