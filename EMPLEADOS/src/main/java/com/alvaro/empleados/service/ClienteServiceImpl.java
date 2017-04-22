package com.alvaro.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvaro.empleados.dao.ClienteDao;
import com.alvaro.empleados.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteDao dao;
	
	public Cliente findById(int id) {
		return dao.findById(id);
	}

	public void saveCliente(Cliente cliente) {
		dao.saveCliente(cliente);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateCliente(Cliente cliente) {
		Cliente entity = dao.findById(cliente.getId());
		if(entity!=null){
			entity.setId(cliente.getId());
			entity.setCif(cliente.getCif());
			entity.setNombre(cliente.getNombre());
		}
	}

	@Override
	public List<Cliente> findAllClientes() {
		
		return dao.findAllClientes();
	}

	

	

	
	
}
