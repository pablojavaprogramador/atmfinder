package com.atm.finder.web.form;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.atm.finder.domain.Direccion;
import com.atm.finder.domain.Geolocalizacion;
import com.atm.finder.domain.Estatus;
import com.atm.finder.domain.Role;

@Data
public class CreateEmployeeForm {
    private String firstName;
    private String lastName;
    private String cajero;
    private String password;
    private String email;

    private String street;
    private String city;
    private String country;

    private Role role;
    private Estatus estatus;
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

	public String getCajero() {
		return cajero;
	}
	public void setCajero(String cajero) {
		this.cajero = cajero;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Estatus getEstatus() {
		return estatus;
	}
	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

    
    
}
