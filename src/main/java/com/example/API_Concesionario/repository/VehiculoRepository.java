package com.example.API_Concesionario.repository;

import com.example.API_Concesionario.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
