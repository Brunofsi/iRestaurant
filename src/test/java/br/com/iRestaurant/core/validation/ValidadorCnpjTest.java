package br.com.iRestaurant.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorCnpjTest {

    @Test
    public void DevePassarCnpjValido(){
        // config
        ValidadorCnpj validadorCnpj = new ValidadorCnpj();
        String cnpjValido = "29546671000134";

        // esperado
        boolean esperado = true;

        // execucao
        boolean resultado = validadorCnpj.valida(cnpjValido);

        // validacao
        Assertions.assertEquals(esperado, resultado);
    }

}
