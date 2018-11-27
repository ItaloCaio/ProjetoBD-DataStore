package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Produto;
import model.dao.ProdutoDaoInterface;

public class ProdutoService implements ProdutoServiceInterface{
	
	@Inject
	private ProdutoDaoInterface produtoDao;
	
	@Override
	public List<Produto> getProduto() {
		// TODO Auto-generated method stub
		return produtoDao.getProduto();
	}

	@Override
	@Transactional
	public Produto adicionarProduto(Produto produto) {
		
		
		return produtoDao.adicionarProduto(produto);
	}

	@Override
	@Transactional
	public void atualizarProduto(Produto produto) {
		
		produtoDao.atualizarProduto(produto);
		
	}

	@Override
	@Transactional
	public void removerProduto(Produto produto) {
		
		produtoDao.removerProduto(produto);
		

	}

}
