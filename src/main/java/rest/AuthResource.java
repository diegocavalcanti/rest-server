package rest;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/auth")
public class AuthResource {

	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@QueryParam("username" ) String username, @QueryParam("password" ) String password) {
		try {
			System.out.println("Recebido ->> UserName:" + username + " password:" + password);
	

			if (username == null || password == null)
				return RestUtil.addHeader(Response.status(Response.Status.UNAUTHORIZED)).build();

			if (!"admin".equalsIgnoreCase(username) || !"admin".equalsIgnoreCase(password))
				return RestUtil.addHeader(Response.status(Response.Status.UNAUTHORIZED)).build();

			JsonObject json = Json.createObjectBuilder().add("info", "autorizado").build();

			return RestUtil.addHeader(Response.status(Status.OK).entity(json)).build();

		} catch (Exception e) {
			JsonObject json = Json.createObjectBuilder().add("error", e.getMessage()).build();
			return RestUtil.addHeader(Response.status(Response.Status.UNAUTHORIZED).entity(json)).build();
		}
	}

}
