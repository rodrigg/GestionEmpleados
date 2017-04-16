package com.alvaro.empleados.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alvaro.empleados.dao.TrabajoDao;
import com.alvaro.empleados.model.Cliente;
import com.alvaro.empleados.model.Trabajo;


public class TrabajoDaoImplTest extends EntityDaoImplTest{

	@Autowired
	TrabajoDao trabajoDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Trabajo.xml"));
		return dataSet;
	}
	
	/* In case you need multiple datasets (mapping different tables) and you do prefer to keep them in separate XML's
	@Override
	protected IDataSet getDataSet() throws Exception {
	  IDataSet[] datasets = new IDataSet[] {
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Trabajo.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Benefits.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Departements.xml"))
	  };
	  return new CompositeDataSet(datasets);
	}
	*/

	@Test
	public void findById(){
		Assert.assertNotNull(trabajoDao.findById(1));
		Assert.assertNull(trabajoDao.findById(3));
	}

	
	@Test
	public void saveTrabajo(){
		trabajoDao.saveTrabajo(getSampleTrabajo());
		Assert.assertEquals(trabajoDao.findAllTrabajos().size(), 3);
	}
	
	
  

	@Test
	public void findAllTrabajos(){
		Assert.assertEquals(trabajoDao.findAllTrabajos().size(), 2);
	}
	
	

	public Trabajo getSampleTrabajo(){
		Trabajo trabajo = new Trabajo();
		trabajo.setNref("Karen");
		trabajo.setfTrabajo(new Date());
		trabajo.setLugar("Cuenca");
		Set<Cliente> clientes = new HashSet<Cliente>();
		Cliente cliente=new Cliente();
		cliente.setId(1);
		clientes.add(cliente);
		trabajo.setClientes(clientes);
		return trabajo;
	}

}
