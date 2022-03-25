package br.com.iRestaurant.core.validation;


import java.util.List;

import static br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

public interface ValidadorSenha {
    List<Erro> valida(String senha, String senhaRepetida);
}
