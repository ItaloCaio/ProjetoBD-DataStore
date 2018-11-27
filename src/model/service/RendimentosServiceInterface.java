package model.service;

import java.util.List;


import model.Rendimentos;

public interface RendimentosServiceInterface {
	
	public Rendimentos salvarRendimentos
	(Rendimentos rendimentos);
	
	public List<Rendimentos> getRendimentos();
	
	public Rendimentos pesquisarRendimentos(Long id);
	public void removerRendimentos(Rendimentos Rendimentos);
	public void atualiza(Rendimentos rendimentos);

}
