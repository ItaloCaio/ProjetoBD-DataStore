package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
import model.Loja;

public class LojaDao implements LojaDaoInterface {
	@PersistenceContext(unitName="ProjetoFeiraPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Loja salvarCliente(Loja loja) {
		
		entityManager.persist(loja);
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Loja> getLoja() {
	
		Query query = entityManager.createQuery("from Loja");
		
		return query.getResultList();
		
	
	}

	@Override
	public Loja pesquisarLoja(Long id) {
		
		Loja loja = null;
		try{
			for(Loja l: getLoja())	
				if(l.getId() == id)
				loja=l;
		}catch(Exception e){
			e.getMessage();
		}
		return loja;
	}

	@Override
	public void removerLoja(Loja loja) {
		
		Loja LojaMerge = entityManager.merge(loja);
		entityManager.remove(LojaMerge);
		
	}

}
