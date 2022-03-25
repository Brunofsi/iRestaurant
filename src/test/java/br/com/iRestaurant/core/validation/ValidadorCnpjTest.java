package br.com.iRestaurant.core.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorCnpjTest {

    @Test
    public void DevePassarCnpjValidoSemPontuacao(){
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

    @Test
    public void DevePassarCnpjValidoComPontuacao(){
        // config
        ValidadorCnpj validadorCnpj = new ValidadorCnpj();
        String cnpjValido = "98.584.756/0001-20";

        // esperado
        boolean esperado = true;

        // execucao
        boolean resultado = validadorCnpj.valida(cnpjValido);

        // validacao
        Assertions.assertEquals(esperado, resultado);
    }

    @Test
    public void NaoDevePassarCnpjInvalido(){
        // config
        ValidadorCnpj validadorCnpj = new ValidadorCnpj();
        String cnpjInvalido1 = "1234";
        String cnpjInvalido2 = "@-/-ABCD";

        // esperado
        boolean esperado = false;

        // execucao
        boolean resultado1 = validadorCnpj.valida(cnpjInvalido1);
        boolean resultado2 = validadorCnpj.valida(cnpjInvalido2);

        // validacao
        Assertions.assertEquals(esperado, resultado1);
        Assertions.assertEquals(esperado, resultado2);
    }

}
