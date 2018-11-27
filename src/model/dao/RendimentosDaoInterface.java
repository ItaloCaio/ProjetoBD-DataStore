package model.dao;

import java.util.List;


import model.Rendimentos;

public interface RendimentosDaoInterface {
	
	public Rendimentos salvarRendimentos
	(Rendimentos rendimentos);
	
	public List<Rendimentos> getRendimentos();
	
	public Rendimentos pesquisarRendimentos(Long id);
	public void removerRendimentos(Rendimentos Rendimentos);
	
	public void atualiza(Rendimentos rendimentos);
	

}
