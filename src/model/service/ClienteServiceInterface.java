package model.service;

import java.util.List;

import model.Cliente;

public interface ClienteServiceInterface {

	
	public Cliente salvarCliente(Cliente cliente);
	public List<Cliente> getClientes();
	public Cliente pesquisarCliente(Integer id);
	public void atualiza(Cliente cliente);
}
