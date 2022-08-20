package com.atm.finder.service;

import com.atm.finder.domain.Empleados;
import com.atm.finder.web.form.CreateEmployeeForm;

import java.util.List;

public interface EmployeeService {
    void create(CreateEmployeeForm form);
    public List<Empleados> getAll();
}
