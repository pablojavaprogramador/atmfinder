package com.atm.finder.service;

import java.util.List;

import com.atm.finder.domain.Cajero;
import com.atm.finder.web.form.AltaCajeroFormulario;



public interface CajerosService {
	 public List<Cajero> getAll();

	  void create(AltaCajeroFormulario form);

	

}
