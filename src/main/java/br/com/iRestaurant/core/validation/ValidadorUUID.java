package br.com.iRestaurant.core.validation;

import java.util.UUID;

public class ValidadorUUID {
    public boolean valida(String uuidNaoValidado){
        try{
            UUID.fromString(uuidNaoValidado);
            return true;
        }catch(IllegalArgumentException ex){
            return false;
        }
    }
}
