//package br.com.qdelicia.core.security.auth;
//
//import br.com.qdelicia.api.usuario.Dono;
//import br.com.qdelicia.api.usuario.DonoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AutenticacaoService implements UserDetailsService {
//
//	@Autowired
//	private DonoRepository repository;
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<Dono> optional = repository.findByEmail(email);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		throw new UsernameNotFoundException("Dados Invalidos");
//
//	}
//
//}
