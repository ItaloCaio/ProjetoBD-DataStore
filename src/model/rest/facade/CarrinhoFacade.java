package model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Cliente;
import model.HistoricoVendas;
import model.Loja;
import model.Produto;
import model.Rendimentos;
import model.service.ClienteService;
import model.service.HistoricoService;
import model.service.LojaService;
import model.service.ProdutoService;
import model.service.RendimentosService;

@Path("/carrinho")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(MediaType.APPLICATION_JSON)
public class CarrinhoFacade {
	
	List<Produto> listaProduto = new ArrayList<>();
	
	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private LojaService lojaService;
	
	@Inject
	private RendimentosService rendiService;
	@Inject 
	private HistoricoService historico;
	@Inject 
	private ClienteService clienteService;
	
	
	
	@GET
	public List<Produto> getProdutos(){
		
		return listaProduto;
	}
	
	
	
	
	@POST
	public Produto comprar(Produto produto, Cliente cliente) throws Exception{
		Loja loja = new Loja();
		loja = lojaService.pesquisarLoja((long) 1);
		Produto pro =  produto;
//		atualizaQuantidade( pro, produto);
		LoginFacade lf = new LoginFacade();
		
		long cpf = 0;
		List<Cliente>  list = lf.getUsuarios();
		for(Cliente c :list){
			c.setSaldo(c.getSaldo() - produto.getValorVenda());
			clienteService.atualiza(c);
			cpf = c.getCpf();
		}
			
		

		
		
		double porcentagemCliente = produto.getValorVenda() * 0.9;
		
		
		Cliente c = null;
				c = produto.getCliente();
		System.out.print(c.getNome());
		c.setSaldo(c.getSaldo() + porcentagemCliente);
		clienteService.atualiza(c);
		
		
		
		return produto;
	}
	
	private void atualizaQuantidade(Produto pro,Produto produto){
		
		
		pro.setQuantidade(pro.getQuantidade() -1);
		
		if(pro.getQuantidade() == 0){
			int id = produto.getId();
			pro.setId(id);
			this.excluir(pro);
		}
		else
			produtoService.atualizarProduto(pro);
	
		
		
	}
	

	@DELETE
	public void excluir(Produto produto){
		Produto prod = produto;
		
		
		produtoService.removerProduto(prod);
	}

}
