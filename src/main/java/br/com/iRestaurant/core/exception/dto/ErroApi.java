package br.com.iRestaurant.core.exception.dto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class ErroApi {

    private String titulo;
    private String mensagemUsuario;
    private List<Erro> erros;

    public ErroApi(String titulo, String mensagemUsuario, List<Erro> erros){
        this.titulo = titulo;
        this.mensagemUsuario = mensagemUsuario;
        this.erros = erros;
    }

    public static class Erro {
        private String propriedade;
        private String mensagem;

        public Erro(String propriedade, String mensagem) {
            this.propriedade = propriedade;
            this.mensagem = mensagem;
        }

        public String getPropriedade() {
            return propriedade;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    public List<Erro> getErros() {
        return erros;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public abstract ResponseEntity<ErroApi> converteParaHttp();
}
