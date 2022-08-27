package com.atm.finder.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.atm.finder.domain.Cajero;
import com.atm.finder.service.CajerosService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/apis")
public class ApisController {

    @Autowired
    private CajerosService CajerosService;

    @RequestMapping(value = "/allCajeros", method = RequestMethod.GET)
    List<Cajero>consultaCajeros(){
        return CajerosService.getAll();
    }
    @RequestMapping(value = "/cajero/{id}", method = RequestMethod.GET)
    Cajero consultaCajero(@PathVariable Integer id){
    	 return  CajerosService.BusquedadId(id);
		//return null;
       
    }
    
    @RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE ,value = "/cajero", method = RequestMethod.POST)
    public String agregarCajero(@RequestBody Cajero cajero){
    	Cajero salvarArticulo = CajerosService.SalvarCajero(cajero);

        return "El Cajero se guardo Correctamente";
    }


    @RequestMapping(value = "/cajero", method = RequestMethod.PUT)
    Cajero actualizarCajero(@RequestBody Cajero cajero){
		
		
		Cajero actualizarArticulo = CajerosService.ActualizarCajero(cajero);

        return actualizarArticulo;
    }
    
    @RequestMapping(value = "/totalcajeros", method = RequestMethod.GET)
    long totalCajeros(){
		
		long actualizarArticulo = CajerosService.numerodeCajeros();
		
        return actualizarArticulo;
    }
    

}
