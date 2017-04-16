package com.alvaro.empleados.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alvaro.empleados.model.Cliente;
import com.alvaro.empleados.model.Trabajo;
import com.alvaro.empleados.service.ClienteService;
import com.alvaro.empleados.service.TrabajoService;

@Controller

public class TrabajoController {

	@Autowired
	TrabajoService service;
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing trabajos.
	 */
	@RequestMapping(value = { "/trabajos", "trabajos/list" }, method = RequestMethod.GET)
	public String listTrabajos(ModelMap model) {

		List<Trabajo> trabajos = service.findAllTrabajos();
		model.addAttribute("trabajos", trabajos);
		return "trabajos/alltrabajos";
	}

	/*
	 * This method will provide the medium to add a new trabajo.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newTrabajo(ModelMap model) {
		Trabajo trabajo = new Trabajo();
		model.addAttribute("trabajo", trabajo);
		model.addAttribute("edit", false);
		return "trabajos/registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving trabajo in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveTrabajo(@Valid Trabajo trabajo, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "trabajos/registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Trabajo].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 */
		/*if(!service.isTrabajoSsnUnique(trabajo.getId(), trabajo.getSsn())){
			FieldError ssnError =new FieldError("trabajo","ssn",messageSource.getMessage("non.unique.ssn", new String[]{trabajo.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}*/
		
		service.saveTrabajo(trabajo);

		model.addAttribute("success", "Trabajo " + trabajo.getNref()+ " registered successfully");
		return "trabajos/success";
	}


	/*
	 * This method will provide the medium to update an existing trabajo.
	 */
	@RequestMapping(value = { "trabajos/edit/{id}" }, method = RequestMethod.GET)
	public String editTrabajo(@PathVariable int id, ModelMap model) {
		Trabajo trabajo = service.findById(id);
		model.addAttribute("trabajo", trabajo);
		model.addAttribute("edit", true);
		return "trabajos/registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating trabajo in database. It also validates the user input
	 */
	@RequestMapping(value = { "trabajos/edit/{id}" }, method = RequestMethod.POST)
	public String updateTrabajo(@Valid Trabajo trabajo, BindingResult result,
			ModelMap model) {

		/*if (result.hasErrors()) {
			return "trabajos/registration";
		}*/

		

		service.updateTrabajo(trabajo);

		model.addAttribute("success", "Trabajo " + trabajo.getNref()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an trabajo by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{ssn}-trabajo" }, method = RequestMethod.GET)
	public String deleteTrabajo(@PathVariable String ssn) {
		
		return "redirect:/list";
	}
	 @ModelAttribute("clientesList")
	    public List<Cliente> initializeClientes() {
	        return clienteService.findAllClientes();
	    }

}
