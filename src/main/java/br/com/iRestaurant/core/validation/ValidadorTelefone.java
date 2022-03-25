package br.com.iRestaurant.core.validation;

import java.util.regex.Pattern;

public class ValidadorTelefone {

    private final String REGEX_TELEFONE = "^\\([1-9]{2}\\)(?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$";

    public boolean valida(String telefone){
        return Pattern.compile(REGEX_TELEFONE).asMatchPredicate().test(telefone);
    }
}
