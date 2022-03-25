//package br.com.qdelicia.api.usuario.autentica_dono.dto;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//public class AutenticacaoDonoRequest {
//
//	@NotBlank
//	@Email
//	private String login;
//
//	@NotBlank
//	private String senha;
//
//	public AutenticacaoDonoRequest(String login, String senha) {
//		this.login = login;
//		this.senha = senha;
//	}
//
//	public UsernamePasswordAuthenticationToken paraSpringSecurityUserPasswordAuth() {
//		return new UsernamePasswordAuthenticationToken(login, senha);
//	}
//
//
//}
