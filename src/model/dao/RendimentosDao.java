package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;

import model.Rendimentos;

public class RendimentosDao implements RendimentosDaoInterface{

	private EntityManager entityManager;
	
	@Override
	public Rendimentos salvarRendimentos(Rendimentos rendimentos) {
		
		entityManager.persist(rendimentos);
		
		return rendimentos;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Rendimentos> getRendimentos() {
		Query query = entityManager.createQuery("from Rendimentos");
		
		return query.getResultList();
	}

	@Override
	public Rendimentos pesquisarRendimentos(Long id) {
		Rendimentos rendimentos = null;
		try{
			for(Rendimentos r: getRendimentos())	
				if(r.getId() == id)
				rendimentos =r;
		}catch(Exception e){
			e.getMessage();
		}
		return rendimentos;
		
	}

	@Override
	public void removerRendimentos(Rendimentos rendimentos) {

		Rendimentos rendimentosMerge = entityManager.merge(rendimentos);
		entityManager.remove(rendimentosMerge);
		
	}
	
	@Override
	public void atualiza(Rendimentos rendimentos){
		Rendimentos rendimentosMerge = entityManager.merge(rendimentos); //Junta o estado da Entity com o estado persistido.
		
		entityManager.persist(rendimentosMerge);
		
	}

}
