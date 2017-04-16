package com.alvaro.empleados.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alvaro.empleados.configuration.AppConfig;
import com.alvaro.empleados.configuration.HibernateConfiguration;
import com.alvaro.empleados.dao.EmployeeDao;
import com.alvaro.empleados.dao.EmployeeDaoImpl;

public class MainModel {
   public static void main(String[] args) {
	   AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
	EmployeeDao dao=context.getBean("employeeDao",EmployeeDaoImpl.class);
	Employee employee=dao.findById(1);
	context.close();
}
}
