package br.com.iRestaurant.api.cardapio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioCardapio extends JpaRepository<Cardapio, UUID> {
}
