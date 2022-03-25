package br.com.iRestaurant.core.validation;


import org.junit.jupiter.api.Test;

import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ValidadorSenhaDonoTest {

    @Test
    public void DevePassarSenhaValida(){
        // config
        ValidadorSenhaDono validadorSenhaDono = new ValidadorSenhaDono();
        String senhaValida = "1234567";
        String senhaRepetidaValida = "1234567";

        // esperado
        int esperado = 0;

        // execucao
        List <Erro> resultado = validadorSenhaDono.valida(senhaValida, senhaRepetidaValida);

        // validacao
        assertEquals(esperado, resultado.size());
    }

    @Test
    public void NaoDevePassarSenhaInvalida(){
        // config
        ValidadorSenhaDono validadorSenhaDono = new ValidadorSenhaDono();
        String senhaInvalida = "12345";
        String senhaRepetidaInvalida = "1234";

        // esperado
        int esperado = 2;

        // execucao
        List<Erro> resultado = validadorSenhaDono.valida(senhaInvalida, senhaRepetidaInvalida);

        // validacao
        assertEquals(esperado, resultado.size());


    }

    @Test
    public void NaoDevePassarSenhaVazia(){
        // config
        ValidadorSenhaDono validadorSenhaDono = new ValidadorSenhaDono();
        String senhaInvalida = "";
        String senhaRepetidaInvalida = "";

        // esperado
        int esperado = 3;

        // execucao
        List<Erro> resultado = validadorSenhaDono.valida(senhaInvalida, senhaRepetidaInvalida);

        // validacao
        assertEquals(esperado, resultado.size());
    }
    
}
