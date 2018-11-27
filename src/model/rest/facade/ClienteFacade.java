package model.rest.facade;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Cliente;


import model.service.ClienteService;


@Path ("/cadastro")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteFacade {
	
	
	
	@Inject
	ClienteService clienteService;

	
	@GET
	public List<Cliente> getUsuarios(){
	
		return clienteService.getClientes();
	}
	
	@POST
	public Cliente salvarProfessor(Cliente cliente){
		
		
		
		return clienteService.salvarCliente(cliente);
	}
	
}
