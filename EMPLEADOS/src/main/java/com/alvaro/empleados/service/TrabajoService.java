package com.alvaro.empleados.service;

import java.util.List;

import com.alvaro.empleados.model.Trabajo;

public interface TrabajoService {

	Trabajo findById(int id);
	
	void saveTrabajo(Trabajo trabajo);
	
	void updateTrabajo(Trabajo trabajo);
	


	List<Trabajo> findAllTrabajos(); 
	
	
	
}
