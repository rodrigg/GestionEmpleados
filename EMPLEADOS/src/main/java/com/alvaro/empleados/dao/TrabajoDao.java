package com.alvaro.empleados.dao;

import java.util.List;

import com.alvaro.empleados.model.Trabajo;

public interface TrabajoDao {

	Trabajo findById(int id);

	void saveTrabajo(Trabajo trabajo);
	
	void updateTrabajo(Trabajo trabajo);
	
	List<Trabajo> findAllTrabajos();

	

}
