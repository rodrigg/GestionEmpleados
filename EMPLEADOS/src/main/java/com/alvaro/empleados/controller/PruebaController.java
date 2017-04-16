package com.alvaro.empleados.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alvaro.empleados.dao.ClienteDao;
import com.alvaro.empleados.dao.TrabajoDao;
import com.alvaro.empleados.model.Cliente;
import com.alvaro.empleados.model.Trabajo;


@Controller
public class PruebaController {
	@Autowired
	TrabajoDao clienteDao;
	@RequestMapping(value ="/prueba" , method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		
		Trabajo clientes =clienteDao.findById(1);
		model.addAttribute("clientes", clientes);
		return "allemployees";
	}
}
