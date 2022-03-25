package br.com.iRestaurant.api.usuario.autentica_dono;

//import br.com.qdelicia.api.usuario.autentica_dono.dto.AutenticacaoDonoResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/auth")
//public class AutenticaDonoController {
//
//	@Autowired
//	private AuthenticationManager authManager;
//
//	@Autowired
//	private GerenciadorToken tokenService;
//
//	@PostMapping
//	public ResponseEntity<AutenticacaoDonoResponse> autenticar(@RequestBody @Valid AutenticacaoDonoRequest requisicao){
//		UsernamePasswordAuthenticationToken dadosLogin = requisicao.paraSpringSecurityUserPasswordAuth();
//		try {
//			Authentication authentication = authManager.authenticate(dadosLogin);
//			String token = tokenService.gerarToken(authentication);
//			return ResponseEntity.ok(new AutenticacaoDonoResponse("Bearer",token));
//		} catch (AuthenticationException e) {
//			return ResponseEntity.badRequest().build();
//		}
//	}
//}
