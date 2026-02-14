package com.example.API_Concesionario.services;

import com.example.API_Concesionario.model.Venta;
import com.example.API_Concesionario.repository.VentaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VentaService {

    @Autowired
    private VentaRepository repository;

    public List<Venta> findAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Optional<Venta> findById(Long id){
        return repository.findById(id);
    }

    public Venta createVenta(Venta venta){
        return repository.save(venta);
    }

    public Venta updateVenta(Venta venta){
        return repository.save(venta);
    }

    public void deleteVenta(Long id){
        repository.deleteById(id);
    }
}
