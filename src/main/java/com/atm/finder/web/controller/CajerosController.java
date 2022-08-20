package com.atm.finder.web.controller;

import com.atm.finder.domain.Cajero;
import com.atm.finder.domain.Direccion;
import com.atm.finder.domain.Empleados;
import com.atm.finder.domain.Geolocalizacion;
import com.atm.finder.domain.Estatus;
import com.atm.finder.domain.Role;
import com.atm.finder.service.CajerosService;
import com.atm.finder.service.EmployeeService;
import com.atm.finder.web.form.AltaCajeroFormulario;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class CajerosController {
	 @Autowired
	private final CajerosService cajeroService = null;
	@Value("${gmaps.api.key}")
	private String gmapsApiKey;

	@GetMapping
	public ModelAndView viewAllUsers() {
//		public List<Empleado> viewAllUsers() {

//		List<Cajero> employees = new ArrayList<Cajero>();
//
//    	Direccion domicilio = new Direccion();
//		domicilio.setCity("Axochiapan");
//		domicilio.setCountry("Morelos");
//		domicilio.setStreet("Emiliano zapta 42");
//		Geolocalizacion localizacion = new Geolocalizacion();
//		localizacion.setLatitude(18.500822);
//		localizacion.setLongitude(-98.755248);
//		
//		Geolocalizacion localizacionDos = new Geolocalizacion();
//		localizacionDos.setLatitude(18.510101);
//		localizacionDos.setLongitude( -98.743660);
//		
//		Geolocalizacion tres = new Geolocalizacion();
//		localizacionDos.setLatitude(18.510386);
//		localizacionDos.setLongitude(-98.761470);
//		
//
//		Role rol = Role.USER;
//		JobPosition jobPosition = JobPosition.JUNIOR;
//		// Role rol=new Role(USER);
//		employees.add(new Cajero("Cajero", "lastName", "username", "password", "email", domicilio, localizacion, rol,
//				jobPosition, false));
//		employees.add(new Cajero("Cajero 2", "lastName", "username", "password", "email", domicilio, localizacionDos,
//				rol, jobPosition, false));
//		
//		employees.add(new Cajero("Cajero 3", "lastName", "cajero3", "password", "email", domicilio, tres,
//				rol, jobPosition, false));
//		


		 List<Cajero> employees = cajeroService.getAll();
		final ModelAndView modelAndView = new ModelAndView("cajeros");
		modelAndView.addObject("employees", employees);
		modelAndView.addObject("gmapsApiKey", gmapsApiKey);
		modelAndView.addObject("todoslosestatus", Estatus.values());
		modelAndView.addObject("createEmployeeForm", new AltaCajeroFormulario());
		modelAndView.addObject("roles", Role.values());
		
		return modelAndView;
	}

	@PostMapping
	public ModelAndView createEmployee(@ModelAttribute AltaCajeroFormulario employeeForm) {
		cajeroService.create(employeeForm);
		return new ModelAndView("redirect:/");
	}

	@GetMapping("/api/cajeros")
	@ResponseBody
	public ResponseEntity<List<Cajero>> getAllUsers() {
//		List<Cajero> employees = new ArrayList<Cajero>();
//
//		Direccion domicilio = new Direccion();
//		domicilio.setCity("Axochiapan");
//		domicilio.setCountry("Axochiapan");
//		domicilio.setStreet("Emiliano zapata 42");
//
//		Geolocalizacion localizacion = new Geolocalizacion();
//		localizacion.setLatitude(18.500822);
//		localizacion.setLongitude(-98.755248);
//		
//		
//		Geolocalizacion localizacionDos = new Geolocalizacion();
//		localizacionDos.setLatitude(18.517339);
//		localizacionDos.setLongitude(-98.780541);
//		
//
//	
//
//		Role rol = Role.USER;
//		JobPosition jobPosition = JobPosition.HR;
//		// Role rol=new Role(USER);
//		employees.add(new Cajero("firstName", "lastName", "username", "password", "email", domicilio, localizacion,
//				rol, jobPosition, false));
//		employees.add(new Cajero("firstName", "lastName", "username", "password", "email", domicilio, localizacionDos,
//				rol, jobPosition, false));
//		
	
		// final List<Cajero> employees = cajeroService.getAll().stream().filter(e->e.getGeoLocation() != null).collect(Collectors.toList());
		 final List<Cajero> employees = cajeroService.getAll();
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/info")
	@ResponseBody
	public ResponseEntity<String> getInfo() {

		return ResponseEntity.ok("datos Info");
	}
}
