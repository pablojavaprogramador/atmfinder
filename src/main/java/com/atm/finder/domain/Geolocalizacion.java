package com.atm.finder.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geolocalizacion {

    private Double latitude;
    private Double longitude;

	public Geolocalizacion(double latitude2, double longitude2) {
		  this.latitude = latitude2;
	      this.longitude = longitude2;
	}
	public Geolocalizacion() {
		// TODO Auto-generated constructor stub
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
    

}
