package model.service;

import java.util.List;


import model.HistoricoVendas;

public interface HistoricoServiceInterface {
	
	public  HistoricoVendas salvarHistoricoVendas(HistoricoVendas historicoVendas);
	
	public List<HistoricoVendas> getHistoricoVendas();
	
	public HistoricoVendas pesquisarHistoricoVendas(Long id);
	public void removerHistoricoVendas(HistoricoVendas HistoricoVendas);
	

}
