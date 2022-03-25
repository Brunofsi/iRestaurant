package br.com.iRestaurant.api.restaurante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RestauranteRepositorio extends JpaRepository<Restaurante, UUID> {
    boolean existsByCnpj(String cnpj);
}
