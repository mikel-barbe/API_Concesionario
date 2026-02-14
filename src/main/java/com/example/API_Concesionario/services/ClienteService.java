package com.example.API_Concesionario.services;

import com.example.API_Concesionario.model.Cliente;
import com.example.API_Concesionario.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Optional<Cliente> findById(Long id){
        return repository.findById(id);
    }

    public Cliente createCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        return repository.save(cliente);
    }

    public void deleteCliente(Long id){
        repository.deleteById(id);
    }

}
