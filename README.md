# iRestaurant
 Um sistema de pedido online simples para restaurantes


# Tecnologias utilizadas
   Back-End
   - Java 12
   - Hibernate
   - Spring (Web, Boot, Data JPA)
   - Postgresql

# Historias

- Como usuário comum eu gostaria de poder visualizar o cardápio dos produtos do restaurante
- Como usuário dono de restaurante gostaria de poder adicionar e alterar os produtos do meu cardápio e os preços
- Como usuário dono de restaurante, gostaria de poder cadastrar meu restaurante ao site	
- Como usuário dono de restaurante gostaria de ter informações sobre o feedback dos usuarios que fazem os pedidos	
- Como usuário comum eu gostaria de entrar na minha conta e ter minhas informações de conta salvas
- Como usuário comum, eu gostaria de poder escolher a forma de pagamento ao finalizar a compra

# Sprint 1
- Ajustes iniciais do projeto - Concluido
 
# Sprint2 

- Como usuário comum eu gostaria de poder visualizar o cardápio dos produtos do restaurante - Concluido
- Como usuário dono de restaurante gostaria de poder adicionar e alterar os produtos do meu cardápio e os preços - Não Concluido
- Como usuário dono de restaurante, gostaria de poder cadastrar meu restaurante ao site	- Não Concluido
- Como usuário dono de restaurante gostaria de ter informações sobre o feedback dos usuarios que fazem os pedidos	- Concluido

# Setup e Execução
- Dependencias
  - Java
  - Docker

Para executar a aplicação será suficiente seguir esses dois passos :

1) Executar o comando no cmd para levantar a instancia dockerizada do sgbd utilizado ( postgresql )
  - "docker container run -d -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -e POSTGRES_DB=test_db --name test-postgresql postgres:latest" 

2) Dentro da pasta principal da aplicação, executar o comando a seguir no cmd para inicializa-la.
  - gradlew bootRun 
