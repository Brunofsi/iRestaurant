package br.com.iRestaurant.core.validation;

import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidadorEmail {

    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public List<Erro> valida(String email){
        List<Erro> erros = new ArrayList<>();
        if(email == null) erros.add(new Erro("email", "O email deve ser preenchido"));
        var regexNaoDeuMatch = !Pattern.compile(EMAIL_REGEX).asMatchPredicate().test(email);
        if( regexNaoDeuMatch ) erros.add(new Erro("email", "O email deve obedecer o padrao"));
        return erros;
    }

}
