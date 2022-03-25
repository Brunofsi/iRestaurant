package br.com.iRestaurant.core.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValidadorTelefoneTest {

    @Test
    public void DevePassarTelefoneValido(){
        // config
        ValidadorTelefone validadorTelefone = new ValidadorTelefone();
        String TelefoneValido = "(34)99985-3277";

        // esperado
        boolean esperado = true;

        // execucao
        boolean resultado = validadorTelefone.valida(TelefoneValido);

        // validacao
        assertEquals(esperado, resultado);
    }

    @Test
    public void NaoDevePassarTelefoneInvalido(){
        // config
        ValidadorTelefone validadorTelefone = new ValidadorTelefone();
        String TelefoneInvalido = "34999853277";

        // esperado
        boolean esperado = false;

        // execucao
        boolean resultado = validadorTelefone.valida(TelefoneInvalido);

        // validacao
        assertEquals(esperado, resultado);
    }


    
}
