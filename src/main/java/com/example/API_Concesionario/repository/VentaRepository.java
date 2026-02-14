package com.example.API_Concesionario.repository;

import com.example.API_Concesionario.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
