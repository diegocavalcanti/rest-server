package rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public abstract class AbstractRestResource {

	public ResponseBuilder response_ok(Object entity){
		
		return  addHeader( Response.status(Response.Status.OK).entity(entity) );
	}
	
	public ResponseBuilder response_no_content(Object entity){
		return  addHeader( Response.status(Response.Status.NO_CONTENT).entity(entity) );
	}
	
	
	public ResponseBuilder response_create(Object entity){
		return  addHeader( Response.status(Response.Status.CREATED).entity(entity) );
	}
	
	public ResponseBuilder addHeader(ResponseBuilder response){
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Credentials", "true");
		response.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		return response;
	}
	

}
