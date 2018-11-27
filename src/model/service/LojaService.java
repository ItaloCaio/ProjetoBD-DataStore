package model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.Loja;
import model.dao.LojaDao;

public class LojaService implements LojaServiceInterface {
	
	@Inject
	private LojaDao lojaDao;
	
	@Override
	@Transactional
	public Loja salvarCliente(Loja loja) {
		
		lojaDao.salvarCliente(loja);
		
		return loja;
	}

	@Override
	public List<Loja> getLoja() {
	
		return lojaDao.getLoja();
	}

	@Override
	public Loja pesquisarLoja(Long id) {
		// TODO Auto-generated method stub
		return lojaDao.pesquisarLoja(id);
	}

	@Override
	@Transactional
	public void removerLoja(Loja loja) {
		
		lojaDao.removerLoja(loja);
		
	}

}
