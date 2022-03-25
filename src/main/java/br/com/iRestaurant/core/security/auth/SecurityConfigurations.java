//package br.com.qdelicia.core.security.auth;
//
//import br.com.qdelicia.api.usuario.DonoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private AutenticacaoService autenticacaoService;
//
//	@Autowired
//	private DonoRepository repository;
//
//	@Autowired
//	private GerenciadorToken gerenciadorToken;
//
//	@Override
//	@Bean
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//
//	//Configuracoes de estrategia de autenticacao
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
//	}
//
//	//Configuracoes de Autorizacao e Acesso
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers(HttpMethod.POST, "api/v1/auth").permitAll()
//				.antMatchers(HttpMethod.POST, "api/v1/donos").permitAll()
//				.antMatchers(HttpMethod.GET, "api/v1/restaurantes/**").permitAll()
//			.anyRequest()
//				.authenticated()
//			.and()
//				.csrf().disable()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//			.and()
//				.addFilterBefore(new AutenticacaoViaTokenFilter(gerenciadorToken, repository),
//						UsernamePasswordAuthenticationFilter.class);
//	}
//}
