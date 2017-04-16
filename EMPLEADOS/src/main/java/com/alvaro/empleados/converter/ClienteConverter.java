package com.alvaro.empleados.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.alvaro.empleados.model.Cliente;
import com.alvaro.empleados.service.ClienteService;

@Component
public class ClienteConverter implements Converter<Object, Cliente>{
	
	
	 
	    @Autowired
	    ClienteService clienteService;
	 
	    /**
	     * Gets UserProfile by Id
	     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	     */
	    @Override
	    public Cliente convert(Object element)  {
	    	Integer id = Integer.parseInt((String)element);
	        Cliente profile= clienteService.findById(id);
	        System.out.println("Profile : "+profile);
	        return profile;
	    }

		
	
	     
	}

