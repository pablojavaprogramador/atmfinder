package com.atm.finder.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    private String street;
    private String city;
    private String country;


    public Direccion() {
		// TODO Auto-generated constructor stub
	}
	public Direccion(String street2, String city2, String country2) {
		// TODO Auto-generated constructor stub
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

	@Override
    public String toString() {
        return String.join(", ", street, city, country);
    }
}
