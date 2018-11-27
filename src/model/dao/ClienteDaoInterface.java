package model.dao;

import java.util.List;

import model.Cliente;

public interface ClienteDaoInterface {
	
	public Cliente salvarCliente(Cliente cliente);
	
	public List<Cliente> getClientes();
	
	public Cliente pesquisarCliente(Long cpf);
	public void removerCliente(Cliente cliente);
	
	public void atualiza(Cliente cliente);

}
