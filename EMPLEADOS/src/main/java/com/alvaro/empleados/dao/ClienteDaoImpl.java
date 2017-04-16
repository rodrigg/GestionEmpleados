package com.alvaro.empleados.dao;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.alvaro.empleados.model.Cliente;

@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDao<Integer, Cliente> implements ClienteDao {

	public Cliente findById(int id) {
		return getByKey(id);
	}

	public void saveCliente(Cliente Cliente) {
		persist(Cliente);
	}

	public void deleteClienteBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Cliente where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAllClientes() {
		Criteria criteria = createEntityCriteria();
		return (List<Cliente>) criteria.list();
	}

	public Cliente findClienteBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Cliente) criteria.uniqueResult();
	}
}
