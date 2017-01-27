package rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("auth")
public class AuthResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("username") String userName, @QueryParam("password") String password) {
		try {

			System.out.println("Recebido ->> UserName:" + userName + " Password: " + password);
			
			if (userName == null && password == null)
				throw new RuntimeException("Usuário ou Senha Não pode ser nulos!");

			if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(password))
				throw new RuntimeException("Usuário ou Senha Inválida!");


			JsonObject json = Json.createObjectBuilder().add("data", "123").build();

			return RestUtil.addHeader(Response.status(Status.OK).entity(json)).build();

		} catch (Exception e) {
			JsonObject json = Json.createObjectBuilder().add("error", e.getMessage()).build();
			return RestUtil.addHeader(Response.status(Response.Status.UNAUTHORIZED).entity(json)).build();
		}
	}

}
