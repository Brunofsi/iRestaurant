package br.com.iRestaurant.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DonoRepository extends JpaRepository<Dono, UUID>{

	
	Optional<Dono> findByEmail(String email);
	
}
