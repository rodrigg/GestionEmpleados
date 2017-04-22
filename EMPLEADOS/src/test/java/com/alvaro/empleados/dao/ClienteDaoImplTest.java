package com.alvaro.empleados.dao;



import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alvaro.empleados.dao.ClienteDao;
import com.alvaro.empleados.model.Cliente;


public class ClienteDaoImplTest extends EntityDaoImplTest{

	@Autowired
	ClienteDao clienteDao;

	@Override
	protected IDataSet getDataSet() throws Exception{
		IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Cliente.xml"));
		return dataSet;
	}
	
	/* In case you need multiple datasets (mapping different tables) and you do prefer to keep them in separate XML's
	@Override
	protected IDataSet getDataSet() throws Exception {
	  IDataSet[] datasets = new IDataSet[] {
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Cliente.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Benefits.xml")),
			  new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Departements.xml"))
	  };
	  return new CompositeDataSet(datasets);
	}
	*/

	@Test
	public void findById(){
		Assert.assertNotNull(clienteDao.findById(1));
		Assert.assertNull(clienteDao.findById(3));
	}


	@Test
	public void saveCliente(){
		clienteDao.saveCliente(getSampleCliente());
		Assert.assertEquals(clienteDao.findAllClientes().size(), 3);
	}
	
	
	
	

	@Test
	public void findAllClientes(){
		Assert.assertEquals(clienteDao.findAllClientes().size(), 2);
	}
	


	public Cliente getSampleCliente(){
		Cliente cliente = new Cliente();
		cliente.setNombre("Karen");
		cliente.setCif("12345");
		
	    return cliente;
	}
}
