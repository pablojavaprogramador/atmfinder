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
    	// return  CajerosService.findById(id).get();
		return null;
       
    }
    

    @RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE ,value = "/cajero", method = RequestMethod.POST)
    public String agregarCajero(@RequestBody Cajero articulo){
    	//Cajero salvarArticulo = CajerosService.save(articulo);

        return "{\"mensaje\":\"Cajero Guardado Correctamente\"}";
    }
    
    @RequestMapping(value = "/cajero", method = RequestMethod.PUT)
    Cajero actualizarCajero(@RequestBody Cajero articulo){
		return articulo;
		
    	//Cajero actualizarArticulo = CajerosService.save(articulo);
       // return actualizarArticulo;
    //	return articulo;
    }

}
