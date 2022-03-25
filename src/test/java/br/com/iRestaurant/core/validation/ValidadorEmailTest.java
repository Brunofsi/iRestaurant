package br.com.iRestaurant.core.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.jupiter.api.Test;

import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

public class ValidadorEmailTest {
    

    @Test
    public void DevePassarEmailValido(){
        // config
        ValidadorEmail validadorEmail = new ValidadorEmail();
        String EmailValido = "teste@hotmail.com";

        // esperado
        int esperado = 0;

        // execucao
        List<Erro> resultado = validadorEmail.valida(EmailValido);

        // validacao
        assertEquals(esperado, resultado.size());
    }

    @Test
    public void NaoDevePassarEmailInvalido(){
        // config
        ValidadorEmail validadorEmail = new ValidadorEmail();
        String EmailValido = "teste";

        // esperado
        int esperado = 1;

        // execucao
        List<Erro> resultado = validadorEmail.valida(EmailValido);

        // validacao
        assertEquals(esperado, resultado.size());
    }



}
