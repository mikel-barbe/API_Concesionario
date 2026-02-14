package com.example.API_Concesionario.repository;


import com.example.API_Concesionario.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
