package model.service;

import java.util.List;

import model.Cliente;
import model.Loja;

public interface LojaServiceInterface {
	
	public Loja salvarCliente(Loja loja);
	
	public List<Loja> getLoja();
	
	public Loja pesquisarLoja(Long id);
	public void removerLoja(Loja Loja);
	

}
