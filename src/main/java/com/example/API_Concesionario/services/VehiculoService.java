package com.example.API_Concesionario.services;

import com.example.API_Concesionario.model.Vehiculo;
import com.example.API_Concesionario.repository.VehiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehiculoService {

    @Autowired
    private VehiculoRepository repository;

    public List<Vehiculo> findAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Optional<Vehiculo> findById(Long id){
        return repository.findById(id);
    }

    public Vehiculo createVehiculo(Vehiculo vehiculo){
        return repository.save(vehiculo);
    }

    public Vehiculo updateVehiculo(Vehiculo vehiculo){
        return repository.save(vehiculo);
    }

    public void deleteVehiculo(Long id){
        repository.deleteById(id);
    }
}
