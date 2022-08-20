package com.atm.finder.repository;

import com.atm.finder.domain.Empleados;
import com.atm.finder.web.controller.CajerosController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Empleados, Integer> {
}
