package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HistoricoVendas;
import model.Rendimentos;

public class HistoricoVendasDao implements HistoricoDaoInterface{

	
	private EntityManager entityManager;
	@Override
	public HistoricoVendas salvarHistoricoVendas(HistoricoVendas historicoVendas) {

		entityManager.persist(historicoVendas);
		return historicoVendas;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<HistoricoVendas> getHistoricoVendas() {
		Query query = entityManager.createQuery("from HistoricoVendas");
		
		
		return query.getResultList();
	}

	@Override
	public HistoricoVendas pesquisarHistoricoVendas(Long id) {

		HistoricoVendas hVendas = null;
		try{
			for(HistoricoVendas hv: getHistoricoVendas())	
				if(hv.getId() == id)
				hVendas =hv;
		}catch(Exception e){
			e.getMessage();
		}
		return hVendas;
	}

	@Override
	public void removerHistoricoVendas(HistoricoVendas historicoVendas) {

		HistoricoVendas historicoMeger = entityManager.merge(historicoVendas);
		entityManager.remove(historicoMeger);
		
	}

}
