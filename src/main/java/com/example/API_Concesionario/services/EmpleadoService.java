package com.example.API_Concesionario.services;

import com.example.API_Concesionario.model.Empleado;
import com.example.API_Concesionario.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public List<Empleado> findAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Optional<Empleado> findById(Long id){
        return repository.findById(id);
    }

    public Empleado createEmpleado(Empleado empleado){
        return repository.save(empleado);
    }

    public Empleado updateEmpleado(Empleado empleado){
        return repository.save(empleado);
    }

    public void deleteEmpleado(Long id){
        repository.deleteById(id);
    }
}
