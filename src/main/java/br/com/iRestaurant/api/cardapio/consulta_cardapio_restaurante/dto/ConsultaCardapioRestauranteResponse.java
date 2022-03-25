package br.com.iRestaurant.api.cardapio.consulta_cardapio_restaurante.dto;

import br.com.iRestaurant.api.cardapio.Cardapio;
import br.com.iRestaurant.api.cardapio.CategoriaCardapio;
import br.com.iRestaurant.api.produto.GrupoOpcaoProduto;
import br.com.iRestaurant.api.produto.OpcaoProduto;
import br.com.iRestaurant.api.produto.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConsultaCardapioRestauranteResponse {

    private UUID id;
    private List<CategoriaCatalogoResponse> categorias;

    public ConsultaCardapioRestauranteResponse(Cardapio cardapioLoja) {
        this.id = cardapioLoja.getId();
        this.categorias = cardapioLoja.getCategorias().stream().map(CategoriaCatalogoResponse::new).collect(Collectors.toList());
    }

    public UUID getId() {
        return id;
    }

    public List<CategoriaCatalogoResponse> getCategorias() { return categorias; }

    private class CategoriaCatalogoResponse  {
        private UUID id;
        private UUID catalogoId;
        private String nome;
        private List<ProdutoResponse> produtos;

        public CategoriaCatalogoResponse(CategoriaCardapio c) {
            this.id = c.getId();
            this.catalogoId = c.getCardapio().getId();
            this.nome = c.getNome();
            this.produtos = c.getProdutos().stream().map(ProdutoResponse::new).collect(Collectors.toList());
        }

        public UUID getId() {
            return id;
        }

        public UUID getCatalogoId() {
            return catalogoId;
        }

        public String getNome() {
            return nome;
        }

        public List<ProdutoResponse> getProdutos() {
            return produtos;
        }
    }

    private class ProdutoResponse  {

        private UUID id;
        private UUID categoriaCatalogoId;
        private String nome;
        private String descricao;
        private BigDecimal precoInicial;

        private List<GrupoOpcaoProdutoResponse> gruposOpcoesProduto;

        public ProdutoResponse(Produto produto) {
            this.id = produto.getId();
            this.categoriaCatalogoId = produto.getCategoriaCatalogo().getId();
            this.nome = produto.getNome();
            this.descricao = produto.getDescricao();
            this.precoInicial = produto.getPrecoInicial();
            this.gruposOpcoesProduto = produto.getGruposOpcoesProduto().stream().map(GrupoOpcaoProdutoResponse::new).collect(Collectors.toList());
        }

        public UUID getId() {
            return id;
        }

        public UUID getCategoriaCatalogoId() {
            return categoriaCatalogoId;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public BigDecimal getPrecoInicial() {
            return precoInicial;
        }

        public List<GrupoOpcaoProdutoResponse> getGruposOpcoesProduto() {
            return gruposOpcoesProduto;
        }
    }

    private class GrupoOpcaoProdutoResponse  {

        private UUID id;
        private UUID produtoId;
        private String nome;
        private String descricao;
        private List<OpcaoProdutoResponse> opcoesProdutos;

        public GrupoOpcaoProdutoResponse(GrupoOpcaoProduto grupo) {
            this.id  = grupo.getId();
            this.produtoId = grupo.getProduto().getId();
            this.nome = grupo.getNome();
            this.descricao = grupo.getDescricao();
            this.opcoesProdutos = grupo.getOpcoesProdutos().stream().map(OpcaoProdutoResponse::new).collect(Collectors.toList());
        }

        public UUID getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }

        public UUID getProdutoId() {
            return produtoId;
        }

        public List<OpcaoProdutoResponse> getOpcoesProdutos() {
            return opcoesProdutos;
        }
    }

    private class OpcaoProdutoResponse  {
        private UUID id;
        private UUID produtoId;
        private BigDecimal preco;
        private String nome;
        private String descricao;

        public OpcaoProdutoResponse(OpcaoProduto opcaoProduto) {
            this.id = opcaoProduto.getId();
            this.produtoId = opcaoProduto.getId();
            this.preco = opcaoProduto.getPreco();
            this.nome = opcaoProduto.getNome();
            this.descricao = opcaoProduto.getDescricao();
        }

        public UUID getId() {
            return id;
        }

        public UUID getProdutoId() {
            return produtoId;
        }

        public BigDecimal getPreco() {
            return preco;
        }

        public String getNome() {
            return nome;
        }

        public String getDescricao() {
            return descricao;
        }
    }

}
