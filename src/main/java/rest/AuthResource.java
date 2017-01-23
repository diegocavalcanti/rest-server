package rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Cliente;

@Path("auth")
public class AuthResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getClientes() {
		
		try {
			
			throw new RuntimeException("deu problema");
			/*
			return Response.status(Response.Status.OK).entity("OK")
					.header("Access-Control-Allow-Origin", "*").build();
					*/
			
		} catch (Exception e) {
			return Response.status(Response.Status.NO_CONTENT).entity(e.getMessage())
					.header("Access-Control-Allow-Origin", "*").build();
		}
		
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("username") String userName, @QueryParam("password") String password) {
		try {
			System.out.println("Recebido ->> UserName:" + userName + " Password: " + password);
			return Response.status(Status.OK)
					.entity("{ \"token\": \"123456\" }")
					.header("Access-Control-Allow-Origin", "*")
					.build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

}
