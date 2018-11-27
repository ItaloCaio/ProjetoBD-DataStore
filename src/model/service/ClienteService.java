package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Cliente;
import model.dao.ClienteDao;

public class ClienteService implements ClienteServiceInterface{

	@Inject
	private ClienteDao clienteDao;
	
	
	@Override
	@Transactional
	public Cliente salvarCliente(Cliente cliente) {
		
		
		
		return clienteDao.salvarCliente(cliente);
	}

	@Override
	public List<Cliente> getClientes() {
	
		return clienteDao.getClientes();
	}

	@Override
	public Cliente pesquisarCliente(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void atualiza(Cliente cliente) {
		
		clienteDao.atualiza(cliente);
		
	}

}
