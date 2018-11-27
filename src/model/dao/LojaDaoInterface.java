package model.dao;

import java.util.List;

import model.Cliente;
import model.Loja;

public interface LojaDaoInterface {
	
	public Loja salvarCliente(Loja loja);
	
	public List<Loja> getLoja();
	
	public Loja pesquisarLoja(Long id);
	public void removerLoja(Loja Loja);
	

}
