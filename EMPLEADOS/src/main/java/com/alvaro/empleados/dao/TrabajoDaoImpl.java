package com.alvaro.empleados.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.alvaro.empleados.model.Trabajo;

@Repository("trabajoDao")
public class TrabajoDaoImpl extends AbstractDao<Integer, Trabajo> implements TrabajoDao {
	
	public Trabajo findById(int id) {
		 Trabajo trabajo = getByKey(id);
	        if(trabajo!=null){
	            Hibernate.initialize(trabajo.getClientes());
	        }
	        return trabajo;
	}

	public void saveTrabajo(Trabajo trabajo) {
		persist(trabajo);
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Trabajo> findAllTrabajos() {
		Criteria criteria = createEntityCriteria();
		return (List<Trabajo>) criteria.list();
	}

	
}
