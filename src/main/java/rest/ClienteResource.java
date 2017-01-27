package rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Cliente;
import service.ClienteServices;




@Path("clientes")
public class ClienteResource {


	ClienteServices clienteService = new ClienteServices();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientes() {
		
		try {
			List<Cliente> listaClientes = clienteService.buscarTodosOsClientes();
			GenericEntity<List<Cliente>> entitys = new GenericEntity<List<Cliente>>(listaClientes) {};
			return RestUtil.addHeader( Response.status(Response.Status.OK).entity(entitys) ).build();
		} catch (Exception e) {
			return RestUtil.addHeader( Response.status(Response.Status.NO_CONTENT).entity(e.getMessage()) ).build();
		}
		
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscarClientePorId(@PathParam("id") int id) {
		return clienteService.buscarCliente(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarCliente(Cliente cliente) {
		cliente = clienteService.adicionarCliente(cliente);
		return RestUtil.addHeader( Response.status(Response.Status.CREATED).entity(cliente.toString()) ).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarCliente(Cliente cliente) {
		cliente = clienteService.atualizarCliente(cliente);
		return RestUtil.addHeader( Response.status(Response.Status.OK).entity(cliente.toString()) ).build();

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluirCliente(@PathParam("id") int id) {
		clienteService.excluirCliente(id);
		return RestUtil.addHeader( Response.ok("<status>success</status>") ).build();

	}
}
