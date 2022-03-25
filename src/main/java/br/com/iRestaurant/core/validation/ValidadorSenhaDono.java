package br.com.iRestaurant.core.validation;

import static br.com.iRestaurant.core.exception.dto.ErroApi.Erro;

import java.util.ArrayList;
import java.util.List;

public class ValidadorSenhaDono implements ValidadorSenha{

    @Override
    public List<Erro> valida(String senha, String senhaRepetida) {
        List<Erro> erros = new ArrayList<>();

        if(senha == null || senha.isBlank()) {
            erros.add(new Erro("senha", "A senha deve vir preenchida"));
            erros.add(new Erro("senha", "A senha deve ser igual àquela digitada para confirmação"));
            erros.add(new Erro("senha", "A senha deve ter entre 6 e 10 caracteres"));
            return erros;
        }

        if(senhaRepetida == null || !senha.contentEquals(senhaRepetida)){
            erros.add(new Erro("senha", "A senha deve ser igual ao campo confirmaSenha"));
        }

        if(!(senha.length() >= 6 && senha.length() <= 10)){
            erros.add(new Erro("senha", "A senha deve ter entre 6 e 10 caracteres"));
        }

        return erros;
    }
}
