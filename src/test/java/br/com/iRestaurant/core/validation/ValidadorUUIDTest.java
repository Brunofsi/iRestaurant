package br.com.iRestaurant.core.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ValidadorUUIDTest {


    @Test
    public void DevePassarUUIDValido(){
        // config
        ValidadorUUID validadorUUID = new ValidadorUUID();
        String UUIDValido = "49ac3929-4b02-464c-accb-27706736206e";

        // esperado
        boolean esperado = true;

        // execucao
        boolean resultado = validadorUUID.valida(UUIDValido);

        // validacao
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void NaoDevePassarUUIDInvalido(){
        // config
        ValidadorUUID validadorUUID = new ValidadorUUID();
        String UUIDInvalido = "1234";

        // esperado
        boolean esperado = false;

        // execucao
        boolean resultado = validadorUUID.valida(UUIDInvalido);

        // validacao
        assertEquals(esperado, resultado);
    }
}
