package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
import model.Produto;



public class ClienteDao implements ClienteDaoInterface{
	@PersistenceContext(unitName="ProjetoFeiraPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Cliente salvarCliente(Cliente cliente) {

		
		entityManager.persist(cliente);
		
		return cliente;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		
		Query query = entityManager.createQuery("from Cliente");
		
		return query.getResultList();
	}

	@Override
	public Cliente pesquisarCliente(Long cpf) {
			Cliente cl = null;
		try{
			for(Cliente c: getClientes())	
				if(c.getCpf() == cpf)
				cl =c;
		}catch(Exception e){
			e.getMessage();
		}
		return cl;
	}
	
	@Override
	public void atualiza(Cliente cliente){
		
		Cliente clienteMerger = entityManager.merge(cliente); //Junta o estado da Entity com o estado persistido.
		//Utilizamos o método merge da EntityManager para atualizar a Entity Professor no BD
		entityManager.persist(clienteMerger);
		
	}
	
	@Override
	public void removerCliente(Cliente cliente) {
	
		Cliente clienteMerge = entityManager.merge(cliente);
		entityManager.remove(clienteMerge);
		
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	
	
	
}
