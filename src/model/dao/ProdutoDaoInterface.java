package model.dao;

import java.util.List;

import model.Produto;

public interface ProdutoDaoInterface {

	
	public List<Produto> getProduto();
	public Produto adicionarProduto(Produto produto);
	public void atualizarProduto(Produto produto);
	public void removerProduto(Produto produto);
	
}
