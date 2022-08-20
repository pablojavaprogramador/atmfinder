package com.atm.finder.repository;


import com.atm.finder.domain.Cajero;
import com.atm.finder.web.controller.CajerosController;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CajeroRepository extends JpaRepository<Cajero, Integer> {
}
