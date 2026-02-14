package com.example.API_Concesionario.controller;
import com.example.API_Concesionario.model.Cliente;
import com.example.API_Concesionario.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<?> getAllClientes(){
        Map<String,Object> response = new HashMap<>();
        try{
            List<Cliente> lista = service.findAll();
            response.put("code",1);
            response.put("mensaje","Lista de clientes obtenida");
            response.put("total",lista.size());
            response.put("data",lista);

            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la obtencion de la lista de clientes");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Cliente> cliente = service.findById(id);

        if(cliente.isPresent()){
            response.put("code",1);
            response.put("mensaje","Cliente encontrado");
            response.put("total",1);
            response.put("data",cliente.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Cliente NO encontrado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente){
        Map<String,Object> response = new HashMap<>();
        try{
            Cliente clienteCreado = service.createCliente(cliente);
            response.put("code",1);
            response.put("mensaje","Vehiculo creado correctamente");
            response.put("total",1);
            response.put("data",clienteCreado);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la creacion del cliente");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        Map<String,Object> response = new HashMap<>();
        Optional<Cliente> clienteBuscado = service.findById(id);

        if(clienteBuscado.isPresent()){
            Cliente clienteEncontrado = clienteBuscado.get();

            clienteEncontrado.setApellidos(cliente.getApellidos());
            clienteEncontrado.setCiudad(cliente.getCiudad());
            clienteEncontrado.setCp(cliente.getCp());
            clienteEncontrado.setDireccion(cliente.getDireccion());
            clienteEncontrado.setDocumento(cliente.getDocumento());
            clienteEncontrado.setEmail(cliente.getEmail());
            clienteEncontrado.setFechaAlta(cliente.getFechaAlta());
            clienteEncontrado.setNombre(cliente.getNombre());
            clienteEncontrado.setPais(cliente.getPais());
            clienteEncontrado.setTelefono(cliente.getTelefono());
            clienteEncontrado.setTipo(cliente.getTipo());

            Cliente clienteActualizado = service.updateCliente(clienteEncontrado);

            response.put("code",1);
            response.put("mensaje","Cliente actualizado correctamente");
            response.put("total",1);
            response.put("data",clienteActualizado);

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Cliente NO actualizado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Cliente> clienteBuscado = service.findById(id);

        if(clienteBuscado.isPresent()){
            service.deleteCliente(id);

            response.put("code",1);
            response.put("mensaje", "Cliente eliminado correctamente");
            response.put("total",1);
            response.put("data",clienteBuscado.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje", "Cliente NO eliminado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
