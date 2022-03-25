package br.com.iRestaurant.api.restaurante.cadastra_restaurante.validador;

import br.com.iRestaurant.core.validation.ValidadorCnpj;
import br.com.iRestaurant.core.validation.ValidadorTelefone;
import br.com.iRestaurant.core.exception.dto.ErroApi;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidadorCadastroLojaRequest {

    private ValidadorCnpj validadorCpnj;
    private ValidadorTelefone validadorTelefone;

    public ValidadorCadastroLojaRequest(ValidadorCnpj validadorCpnj, ValidadorTelefone validadorTelefone){
        this.validadorTelefone = validadorTelefone;
        this.validadorCpnj = validadorCpnj;
    }

    public List<ErroApi.Erro> valida(String cnpj, String telefone){
        List<ErroApi.Erro> resultadoValidacao = new ArrayList<>();
        boolean cnpjEhInvalido = ! validadorCpnj.valida(cnpj);
        if(cnpjEhInvalido) resultadoValidacao.add(new ErroApi.Erro("cnpj", "O Cnpj deve ser valido"));
        boolean telefoneEhInvalido = ! validadorTelefone.valida(telefone);
        if(telefoneEhInvalido) resultadoValidacao.add(new ErroApi.Erro("telefone", "O telefone deve seguir o padrao \"(xx)xxxxx-xxxx\" "));
        return resultadoValidacao;
    }

}
