package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Produto;



public class ProdutoDao implements ProdutoDaoInterface {
	@PersistenceContext(unitName= "ProjetoFeiraPersistenceUnit")
	private EntityManager entityManager;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> getProduto() {
		Query query = entityManager.createQuery("from Produto");
		return query.getResultList();
	}

	@Override
	public Produto adicionarProduto(Produto produto) {
		
		produto.setId(null);
		
		entityManager.persist(produto);
		return produto;
	}

	@Override
	public void atualizarProduto(Produto produto) {
		
		
			Produto produtoMerge = entityManager.merge(produto); //Junta o estado da Entity com o estado persistido.
			//Utilizamos o método merge da EntityManager para atualizar a Entity Professor no BD
			entityManager.persist(produtoMerge);
		
		
	}

	@Override
	public void removerProduto(Produto produto) {
	
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.remove(produtoMerge);
		
		
	}
	
	

}
