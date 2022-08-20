package com.atm.finder.service;


import java.util.Optional;

import com.atm.finder.domain.Geolocalizacion;

public interface GeoLocationService {
    Optional<Geolocalizacion> computeGeoLocation(String fullAddressLine);
}
