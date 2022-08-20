package com.atm.finder.service;

import com.atm.finder.domain.Empleados;
import com.atm.finder.web.form.AltaCajeroFormulario;

import java.util.List;

public interface EmployeeService {
    void create(AltaCajeroFormulario form);
    public List<Empleados> getAll();
}
