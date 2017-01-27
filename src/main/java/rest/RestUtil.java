package rest;

import javax.ws.rs.core.Response.ResponseBuilder;

public class RestUtil {
	
	public static ResponseBuilder addHeader(ResponseBuilder response){
		response.header("Access-Control-Allow-Origin", "*");
		response.header("Access-Control-Allow-Methods", "GET, POST, PUT");
		response.header("Content-Type", "application/json;charset=utf-8");
		return response;
		
	}

}
