package model.service;

import java.util.List;

import javax.transaction.Transactional;

import model.Rendimentos;
import model.dao.RendimentosDao;

public class RendimentosService implements RendimentosServiceInterface {

	
	private RendimentosDao rendimentosDao;
	
	@Override
	public Rendimentos salvarRendimentos(Rendimentos rendimentos) {
		
		return rendimentosDao.salvarRendimentos(rendimentos);
	}

	@Override
	public List<Rendimentos> getRendimentos() {
		
		return rendimentosDao.getRendimentos();
	}
	@Transactional
	@Override
	public Rendimentos pesquisarRendimentos(Long id) {
		
		return rendimentosDao.pesquisarRendimentos(id);
	}

	@Override
	public void removerRendimentos(Rendimentos rendimentos) {
		rendimentosDao.removerRendimentos(rendimentos);
		
	}

	@Override
	@Transactional
	public void atualiza(Rendimentos rendimentos) {
		rendimentosDao.atualiza(rendimentos);
		
	}

}
