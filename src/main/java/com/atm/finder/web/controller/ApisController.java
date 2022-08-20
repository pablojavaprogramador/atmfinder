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
public class ApisController {

    @Autowired
    private CajerosService CajerosService;

    @RequestMapping(value = "/cajeros", method = RequestMethod.GET)
    List<Cajero>consultaCajeros(){
        return CajerosService.getAll();
    }


}
