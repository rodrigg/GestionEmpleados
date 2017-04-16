package com.alvaro.empleados.service;

import java.util.List;

import com.alvaro.empleados.model.Cliente;

public interface ClienteService {

	Cliente findById(int id);
	
	void saveCliente(Cliente cliente);
	
	void updateCliente(Cliente cliente);
	


	List<Cliente> findAllClientes(); 
	
	
	
}
