package com.atm.finder.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "employeesss")
public class Empleados extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Geolocalizacion getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(Geolocalizacion geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Estatus getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(Estatus jobPosition) {
		this.jobPosition = jobPosition;
	}

	public boolean isGeoProcessed() {
		return geoProcessed;
	}

	public void setGeoProcessed(boolean geoProcessed) {
		this.geoProcessed = geoProcessed;
	}

	public Direccion getAddress() {
		return address;
	}

	@Embedded
    private Direccion address;

    @Embedded
    private Geolocalizacion geoLocation;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Estatus jobPosition;

    private boolean geoProcessed = false;

    public Empleados(final String firstName, final String lastName, final String username, final String email,
                    final Direccion address, final Role role, final Estatus jobPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.address = address;
        this.role = role;
        this.jobPosition = jobPosition;
        
    }

   

	public Empleados(String string, String string2, String string3, String string4, String string5, Direccion domicilio,
			Geolocalizacion localizacion, Role rol, Estatus jobPosition2, boolean b) {
	    this.firstName = string;
        this.lastName = string2;
        this.username = string3;
        this.email = string4;
        this.address = domicilio;
        this.role = rol;
        this.geoLocation = localizacion;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleados that = (Empleados) o;
        return this.id != null && that.id.equals(this.id);
    }

    public String getFullName() {
        return firstName + ", " + lastName;
    }

    public String getFullAddress() {
        return this.address.toString();
    }

    public void setAddress(final Direccion address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}