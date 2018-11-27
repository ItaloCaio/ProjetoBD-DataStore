package model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Produto;
import model.service.ProdutoServiceInterface;

@Path("/produto")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoFacade {
	
	@Inject
	private ProdutoServiceInterface produtoService;
	
	
	@GET
	public List<Produto> getProdutos(){
		
		
		return produtoService.getProduto();
	}
	
	
	@POST
	public Produto adicionarProduto(Produto produto){
		
		produtoService.adicionarProduto(produto);
		
		return produto;
		
	}
	
	

}
