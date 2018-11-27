package model.rest.facade;


import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import model.Cliente;
import model.dao.ClienteDao;
import model.service.ClienteService;




@Path("/login")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes(MediaType.APPLICATION_JSON)
public class LoginFacade {

	@Inject
	private ClienteService clienteService;
	private 	
	@Inject
	ClienteDao clienteDao;
	static List<Cliente> listC = new ArrayList<>();

	@GET
	public static List<Cliente> getUsuarios() throws Exception {

		return listC;
	}

	@POST
	public Cliente entrar(Cliente cliente) {
		
		Cliente	clienteReturn = null;
		
		try{ 
			clienteReturn = clienteDao.pesquisarCliente(cliente.getCpf());

		}catch(Exception e){
			e.getMessage();
		}
		
		if(clienteReturn != null){
			if (autentica(cliente, clienteReturn)){
				listC.add(clienteReturn);
				return clienteReturn;
			}
			
				
		}
		
		return null;
	}

	private boolean autentica(Cliente clienteWeb, Cliente clienteBD) {
	
		
		if ((clienteWeb.getCpf() == clienteBD.getCpf()) && clienteWeb.getSenha().equals(clienteBD.getSenha())) {
			
				return true;
			}
			

		return false;

	}

	
	@DELETE
	public void removerCliente(){
		System.out.println("Entrei no remove");
		listC.remove(0);
	
	}
	
}
