package com.alvaro.empleados.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvaro.empleados.dao.TrabajoDao;
import com.alvaro.empleados.model.Trabajo;

@Service("trabajoService")
@Transactional
public class TrabajoServiceImpl implements TrabajoService {

	@Autowired
	private TrabajoDao dao;
	
	public Trabajo findById(int id) {
		return dao.findById(id);
	}

	public void saveTrabajo(Trabajo trabajo) {
		dao.saveTrabajo(trabajo);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db on,ce transaction ends. 
	 */
	public void updateTrabajo(Trabajo trabajo) {
		
		dao.updateTrabajo(trabajo);
		
	}

	@Override
	public List<Trabajo> findAllTrabajos() {
		
		return dao.findAllTrabajos();
	}

	

	

	
	
}
