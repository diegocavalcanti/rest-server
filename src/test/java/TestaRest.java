import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;

import junit.framework.Assert;
import model.Cliente;




/***
 * Demo https://demoisellelab.wordpress.com/2014/04/25/crud-e-rest-o-basico-das-aplicacoes/
 * 
 * @author diego.daniel
 *
 */



public class TestaRest {
	private String URI = "http://localhost:8080/rest-server/rest/clientes";
	
//	@Test()
	public void buscarClientesTest() {

		try {

		     ResteasyClient client = new ResteasyClientBuilder().build();
		        ResteasyWebTarget target = client.target(URI);
		        Response response = target.request().get();
		        //Read output in string format
		        String value = response.readEntity(String.class);
		        System.out.println("Response Status:"+response.getStatus());
		        System.out.println("Response Body:"+value);
		        assertTrue(response.getStatus() == 200);
		        response.close();  

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
//	@Test
	public void incluirClienteTest() {

		try {

		        ResteasyClient client = new ResteasyClientBuilder().build();
		        ResteasyWebTarget target = client.target(URI);
		        Cliente cidade = new Cliente(999,"Cliente Novo",144000L, new Date());
		     //   String cidade = "{\"id\":998,\"countryName\":\"Angola\",\"population\":144000}";
		        Response response = target.request().post( Entity.entity(cidade, MediaType.APPLICATION_JSON)); 
		        System.out.println("Response Status:"+response.getStatus());
		        assertTrue(response.getStatus() == 200);
		        response.close();  

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
//	@Test
	public void alteraClienteTest() {

		try {

		        ResteasyClient client = new ResteasyClientBuilder().build();
		        ResteasyWebTarget target = client.target(URI);
		        Cliente cidade = new Cliente(999,"Cliente Novo Atualizado",145000L, new Date(2015,8,12));
		     //   String cidade = "{\"id\":998,\"countryName\":\"Angola\",\"population\":144000}";
		        Response response = target.request().put( Entity.entity(cidade, MediaType.APPLICATION_JSON)); 
		        System.out.println("Response Status:"+response.getStatus());
		        assertTrue(response.getStatus() == 200);
		        response.close();  

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
//	@Test
	public void removeClienteTest() {

		try {

		        ResteasyClient client = new ResteasyClientBuilder().build();
		        String URI = "http://localhost:8080/lfm-server/rest/cidades";

		        ResteasyWebTarget target = client.target(URI).path(String.valueOf(1));
		        Response response = target.request().delete();
		       		        
		        System.out.println("Response Status:"+response.getStatus());
		        assertTrue(response.getStatus() == 204);
		        response.close();  

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
