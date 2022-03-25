package br.com.iRestaurant.api.usuario.autentica_dono.dto;

public class AutenticacaoDonoResponse {

	private String tipo;
	
	private String token;

	public AutenticacaoDonoResponse(String tipo, String token) {
		this.tipo = tipo;
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public String getToken() {
		return token;
	}
}
