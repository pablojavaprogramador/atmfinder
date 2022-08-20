package com.atm.finder.service;

import com.atm.finder.domain.Direccion;
import com.atm.finder.domain.Empleados;
import com.atm.finder.repository.EmployeeRepository;
import com.atm.finder.web.form.CreateEmployeeForm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository = null;
    private final GeoLocationService geoLocationService = null;

    @Transactional
    public void create(CreateEmployeeForm form) {
        final Empleados employee = new Empleados(form.getFirstName(), form.getLastName(), form.getCajero(),
                                               form.getEmail(),
                                               new Direccion(form.getStreet(), form.getCity(), form.getCountry()),
                                               form.getRole(), form.getEstatus());
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public List<Empleados> getAll() {
        final List<Empleados> employees = employeeRepository.findAll();
       employees.forEach(this::computeAddress);
        return employees;
    }

    private void computeAddress(Empleados employee) {
        if (employee.getAddress() != null && employee.getGeoLocation() == null && !employee.isGeoProcessed()) {
            geoLocationService.computeGeoLocation(employee.getAddress().toString())
                    .ifPresent(employee::setGeoLocation);
            employee.setGeoProcessed(true);
        }
    }
}
