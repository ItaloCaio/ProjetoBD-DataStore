package model.dao;

import java.util.List;


import model.HistoricoVendas;

public interface HistoricoDaoInterface {
	
	public  HistoricoVendas salvarHistoricoVendas(HistoricoVendas historicoVendas);
	
	public List<HistoricoVendas> getHistoricoVendas();
	
	public HistoricoVendas pesquisarHistoricoVendas(Long id);
	public void removerHistoricoVendas(HistoricoVendas HistoricoVendas);
	

}
