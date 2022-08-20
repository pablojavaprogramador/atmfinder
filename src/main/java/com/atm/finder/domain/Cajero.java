package com.atm.finder.domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cajeros")
public class Cajero extends AbstractEntity {

	private String firstName;
    private String lastName;
    private String cajero;
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


	public boolean isGeoProcessed() {
		return geoProcessed;
	}

	public void setGeoProcessed(boolean geoProcessed) {
		this.geoProcessed = geoProcessed;
	}

	public Direccion getAddress() {
		return address;
	}

	
	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}


	@Embedded
    private Direccion address;

    @Embedded
    private Geolocalizacion geoLocation;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    private boolean geoProcessed = false;


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