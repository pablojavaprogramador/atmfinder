package com.atm.finder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atm.finder.domain.Cajero;
import com.atm.finder.domain.Direccion;
import com.atm.finder.repository.CajeroRepository;
import com.atm.finder.web.form.AltaCajeroFormulario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CajerosServiceImpl implements CajerosService {
	Cajero cajeroRespuesta = null;
	@Autowired
	private final CajeroRepository cajeroRepository = null;
	@Autowired
	private final GeoLocationService geoLocationService = null;

	@Override
	@Transactional
	public List<Cajero> getAll() {

		final List<Cajero> cajeros = cajeroRepository.findAll();
		 cajeros.forEach(this::computeAddress);
		// cajeros.forEach(computeAddress);
		return cajeros;
	}

	@Override
	public void create(AltaCajeroFormulario form) {
		final Cajero employee = new Cajero(form.getFirstName(), form.getLastName(), form.getCajero(), form.getEmail(),
				new Direccion(form.getStreet(), form.getCity(), form.getCountry()), form.getRole(), form.getEstatus());
		if (employee.getAddress() != null && employee.getGeoLocation() == null && !employee.isGeoProcessed()) {
			geoLocationService.computeGeoLocation(employee.getAddress().toString()).ifPresent(employee::setGeoLocation);
			cajeroRepository.save(employee);
		}

	}

	private void computeAddress(Cajero cajero) {
		if (cajero.getAddress() != null && cajero.getGeoLocation() == null && !cajero.isGeoProcessed()) {
			geoLocationService.computeGeoLocation(cajero.getAddress().toString()).ifPresent(cajero::setGeoLocation);
			cajero.setGeoProcessed(true);
		}
	}

	@Override
	public Cajero BusquedadId(Integer id) {
		cajeroRespuesta = cajeroRepository.findById(id).get();
		return cajeroRespuesta;
	}

	@Override
	public Cajero SalvarCajero(Cajero cajero) {
		cajeroRespuesta = cajeroRepository.save(cajero);
		return cajeroRespuesta;
	}

	@Override
	public Cajero ActualizarCajero(Cajero cajero) {
		cajeroRespuesta = cajeroRepository.save(cajero);
		
		return cajeroRespuesta;
	}

	@Override
	public long numerodeCajeros() {
		 long  numeroCajeros =  cajeroRepository.count();
		 
		return numeroCajeros;
	}

}
