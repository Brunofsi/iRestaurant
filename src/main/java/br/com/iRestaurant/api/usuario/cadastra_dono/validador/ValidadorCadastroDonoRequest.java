package br.com.iRestaurant.api.usuario.cadastra_dono.validador;

import br.com.iRestaurant.core.exception.dto.ErroApi.Erro;
import br.com.iRestaurant.core.validation.ValidadorEmail;
import br.com.iRestaurant.core.validation.ValidadorSenha;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ValidadorCadastroDonoRequest {

    private final ValidadorEmail validadorEmail;
    private final ValidadorSenha validadorSenha;

    public ValidadorCadastroDonoRequest(ValidadorEmail validadorEmail, ValidadorSenha validadorSenha) {
        this.validadorEmail = validadorEmail;
        this.validadorSenha = validadorSenha;
    }

    public List<Erro> valida(String email, String senha, String senhaRepetida){
        var errosEmail = validadorEmail.valida(email);
        var errosSenha = validadorSenha.valida(senha, senhaRepetida);
        return Stream.concat(
                errosEmail.stream(),
                errosSenha.stream()
        ).collect(Collectors.toList());
    }
}
