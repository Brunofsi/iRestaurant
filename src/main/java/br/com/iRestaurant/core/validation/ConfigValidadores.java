package br.com.iRestaurant.core.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigValidadores {


    @Bean
    public ValidadorCnpj validadorCnpj(){
        return new ValidadorCnpj();
    }

    @Bean
    public ValidadorTelefone validadorTelefone(){
        return new ValidadorTelefone();
    }

    @Bean
    public ValidadorUUID validadorUUID(){
        return new ValidadorUUID();
    }

    @Bean
    public ValidadorEmail validadorEmail(){ return new ValidadorEmail(); }

    @Bean
    public ValidadorSenha validadorSenhaDono(){
        return new ValidadorSenhaDono();
    }

}
