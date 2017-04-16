package com.alvaro.empleados.dao;

import java.util.List;

import com.alvaro.empleados.model.Cliente;

public interface ClienteDao {

	Cliente findById(int id);

	void saveCliente(Cliente cliente);
	
	void deleteClienteBySsn(String ssn);
	
	List<Cliente> findAllClientes();

	Cliente findClienteBySsn(String ssn);

}
