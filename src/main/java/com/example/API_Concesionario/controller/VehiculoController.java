package com.example.API_Concesionario.controller;

import com.example.API_Concesionario.model.Vehiculo;
import com.example.API_Concesionario.services.VehiculoService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService service;

    @GetMapping
    public ResponseEntity<?> getAllVehiculos(){
        Map<String,Object> response = new HashMap<>();
        try{
            List<Vehiculo> lista = service.findAll();
            response.put("code",1);
            response.put("mensaje","Lista de vehiculos obtenida");
            response.put("total",lista.size());
            response.put("data",lista);

            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la obtencion de la lista de vehiculos");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Vehiculo> vehiculo = service.findById(id);

        if(vehiculo.isPresent()){
            response.put("code",1);
            response.put("mensaje","Vehiculo encontrado");
            response.put("total",1);
            response.put("data",vehiculo.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Vehiculo NO encontrado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> createVehiculo(@RequestBody Vehiculo vehiculo){
        Map<String,Object> response = new HashMap<>();
        try{
            Vehiculo vehiculoCreado = service.createVehiculo(vehiculo);
            response.put("code",1);
            response.put("mensaje","Vehiculo creado correctamente");
            response.put("total",1);
            response.put("data",vehiculoCreado);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la creacion del vehiculo");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo){
        Map<String,Object> response = new HashMap<>();
        Optional<Vehiculo> vehiculoBuscado = service.findById(id);

        if(vehiculoBuscado.isPresent()){
            Vehiculo vehiculoEncontrado = vehiculoBuscado.get();

            vehiculoEncontrado.setAnio(vehiculo.getAnio());
            vehiculoEncontrado.setColor(vehiculo.getColor());
            vehiculoEncontrado.setCombustible(vehiculo.getCombustible());
            vehiculoEncontrado.setDescripcion(vehiculo.getDescripcion());
            vehiculoEncontrado.setEstado(vehiculo.getEstado());
            vehiculoEncontrado.setFechaEntrada(vehiculo.getFechaEntrada());
            vehiculoEncontrado.setMarca(vehiculo.getMarca());
            vehiculoEncontrado.setKm(vehiculo.getKm());
            vehiculoEncontrado.setMatricula(vehiculo.getMatricula());
            vehiculoEncontrado.setModelo(vehiculo.getModelo());
            vehiculoEncontrado.setPrecio(vehiculo.getPrecio());
            vehiculoEncontrado.setTipo(vehiculo.getTipo());
            vehiculoEncontrado.setTransmision(vehiculo.getTransmision());
            vehiculoEncontrado.setVersion(vehiculo.getVersion());
            vehiculoEncontrado.setVin(vehiculo.getVin());

            Vehiculo vehiculoActualizado = service.updateVehiculo(vehiculoEncontrado);

            response.put("code",1);
            response.put("mensaje","Vehiculo actualizado correctamente");
            response.put("total",1);
            response.put("data",vehiculoActualizado);

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Vehiculo NO actualizado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Vehiculo> vehiculoBuscado = service.findById(id);

        if(vehiculoBuscado.isPresent()){
            service.deleteVehiculo(id);

            response.put("code",1);
            response.put("mensaje", "Vehiculo eliminado correctamente");
            response.put("total",1);
            response.put("data",vehiculoBuscado.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje", "Vehiculo NO eliminado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
