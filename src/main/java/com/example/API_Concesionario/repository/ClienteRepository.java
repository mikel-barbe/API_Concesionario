package com.example.API_Concesionario.repository;

import com.example.API_Concesionario.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
}
