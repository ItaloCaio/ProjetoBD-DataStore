package model.service;

import java.util.List;

import javax.transaction.Transactional;

import model.HistoricoVendas;
import model.dao.HistoricoVendasDao;

public class HistoricoService implements HistoricoServiceInterface{

	private HistoricoVendasDao historicoDao;
	
	@Override
	@Transactional
	public HistoricoVendas salvarHistoricoVendas(HistoricoVendas historicoVendas) {
		historicoDao.salvarHistoricoVendas(historicoVendas);
		return historicoVendas;
	}

	@Override
	public List<HistoricoVendas> getHistoricoVendas() {


		
		return historicoDao.getHistoricoVendas();
	}

	@Override
	public HistoricoVendas pesquisarHistoricoVendas(Long id) {
		
		
		return historicoDao.pesquisarHistoricoVendas(id);
	}

	@Override
	@Transactional
	public void removerHistoricoVendas(HistoricoVendas historicoVendas) {
		
		historicoDao.removerHistoricoVendas(historicoVendas);
		
	}

}
