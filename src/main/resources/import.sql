insert into dono (id, email, senha) values ('0cabbd8a-de57-4c57-b0c8-8a0a97eefe75', 'donotest@gmail.com.br', 'senhadono123');
insert into cliente(id, email, senha) values ('fb31f557-2e9d-4295-a9c1-4a7a2a7fa387', 'clientetest@gmail.com.br', 'senhacliente123')
insert into restaurante (id, dono_id, cnpj, telefone, nome, tipo) values ('10ad614a-adf5-4725-9fbb-1be4685a8888', '0cabbd8a-de57-4c57-b0c8-8a0a97eefe75','57448893000150', '(34)99880-7471', 'Brunella Pizzaria', 1);
insert into cardapio (restaurante_id) values ('10ad614a-adf5-4725-9fbb-1be4685a8888');
insert into categoria_cardapio (id, cardapio_restaurante_id, nome) values ('22cdbef0-1286-4cc1-8b6a-ebd2ebb73524', '10ad614a-adf5-4725-9fbb-1be4685a8888', 'Destaques');
insert into produto (id, categoria_cardapio_id, nome, descricao, preco_inicial) values ('c9c121d4-7680-47dd-a8cb-f56799006c56', '22cdbef0-1286-4cc1-8b6a-ebd2ebb73524', 'PIZZA GRANDE + GUARANÁ ANTARTICA 1,5L', 'Escolha uma de nossas pizzas mais tradicionais e ganhe um guarana 1.5l', 87.90);
insert into grupo_opcao_produto (id, produto_id, nome, descricao) values ('6734e992-895e-4ee5-a040-551070f4c227', 'c9c121d4-7680-47dd-a8cb-f56799006c56', 'Pizza Grande', 'Escolha 1 opção.');
insert into opcao_produto (id, grupo_opcao_produto_id, nome, descricao, preco) values ('cae27811-c622-462e-b208-60fdc699ef55', '6734e992-895e-4ee5-a040-551070f4c227', 'Frango com Catupiry', 'Molho de tomate, frango desfiado, Catupiry, mussarela e oregano', 45.00);



insert into pedido (id, restaurante_id, cliente_id, feedback_cliente, data_criacao, valor_sub_total, valor_frete, valor_total)
       values ('9df5b1f5-c7a3-436e-9771-3115af01a6cf', '10ad614a-adf5-4725-9fbb-1be4685a8888', 'fb31f557-2e9d-4295-a9c1-4a7a2a7fa387',
               5, NOW(), 87.90, 0.00, 87.90);


INSERT INTO public.item_pedido
(id, quantidade, valor, pedido_id, produto_id) VALUES(?, 0, 0, ?, ?);
