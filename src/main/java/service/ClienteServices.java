package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.Cliente;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class ClienteServices {

	static HashMap<Integer, Cliente> listaClientes = getCountryIdMap();

	public ClienteServices() {
		super();

		if (listaClientes == null) {
			listaClientes = new HashMap<Integer, Cliente>();

			listaClientes.put(1, new Cliente(1, "Diego", 36L, new Date(81,2,4)) );
			listaClientes.put(4, new Cliente(4, "Caroline", 31L, new Date(84,9,17)) );
			listaClientes.put(3, new Cliente(3, "Gabriela", 5L, new Date(11,10,25)) );
			listaClientes.put(2, new Cliente(2, "Rodrigo", 1L, new Date(20,12,25)) );
		}
	}

	public List<Cliente> buscarTodosOsClientes() {
		List<Cliente> countries = new ArrayList<Cliente>(listaClientes.values());
		return countries;
	}

	public Cliente buscarCliente(int id) {
		Cliente cliente = listaClientes.get(id);
		return cliente;
	}

	public Cliente adicionarCliente(Cliente cliente) {
		cliente.setId(listaClientes.size() + 1);
		listaClientes.put(cliente.getId(), cliente);
		return cliente;
	}

	public Cliente atualizarCliente(Cliente cliente) {
		if (cliente.getId() <= 0)
			return null;
		listaClientes.put(cliente.getId(), cliente);
		return cliente;

	}

	public void excluirCliente(int id) {
		listaClientes.remove(id);
	}

	public static HashMap<Integer, Cliente> getCountryIdMap() {
		return listaClientes;
	}
}
