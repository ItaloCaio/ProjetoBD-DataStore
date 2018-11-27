package model.service;

import java.util.List;

import model.Produto;

public interface ProdutoServiceInterface {
	
	public List<Produto> getProduto();
	public Produto adicionarProduto(Produto produto);
	public void atualizarProduto(Produto produto);
	public void removerProduto(Produto produto);

}
