package com.example.API_Concesionario.controller;

import com.example.API_Concesionario.model.Empleado;
import com.example.API_Concesionario.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService service;

    @GetMapping
    public ResponseEntity<?> getAllEmpleados(){
        Map<String,Object> response = new HashMap<>();
        try{
            List<Empleado> lista = service.findAll();
            response.put("code",1);
            response.put("mensaje","Lista de empleados obtenida");
            response.put("total",lista.size());
            response.put("data",lista);

            return ResponseEntity.ok(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la obtencion de la lista de empleados");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Empleado> empleado = service.findById(id);

        if(empleado.isPresent()){
            response.put("code",1);
            response.put("mensaje","Empleado encontrado");
            response.put("total",1);
            response.put("data",empleado.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Empleado NO encontrado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEmpleado(@RequestBody Empleado empleado){
        Map<String,Object> response = new HashMap<>();
        try{
            Empleado empleadoCreado = service.createEmpleado(empleado);
            response.put("code",1);
            response.put("mensaje","Empleado creado correctamente");
            response.put("total",1);
            response.put("data",empleadoCreado);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la creacion del empleado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmpleado(@PathVariable Long id, @RequestBody Empleado empleado){
        Map<String,Object> response = new HashMap<>();
        Optional<Empleado> empleadoBuscado = service.findById(id);

        if(empleadoBuscado.isPresent()){
            Empleado empleadoEncontrado = empleadoBuscado.get();

            empleadoEncontrado.setActivo(empleado.isActivo());
            empleadoEncontrado.setApellidos(empleado.getApellidos());
            empleadoEncontrado.setEmail(empleado.getEmail());
            empleadoEncontrado.setFechaContratacion(empleado.getFechaContratacion());
            empleadoEncontrado.setNombre(empleado.getNombre());
            empleadoEncontrado.setRol(empleado.getRol());
            empleadoEncontrado.setTelefono(empleado.getTelefono());

            Empleado empleadoActualizado = service.updateEmpleado(empleadoEncontrado);

            response.put("code",1);
            response.put("mensaje","Empleado actualizado correctamente");
            response.put("total",1);
            response.put("data",empleadoActualizado);

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Empleado NO actualizado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmpleado(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Empleado> empleadoBuscado = service.findById(id);

        if(empleadoBuscado.isPresent()){
            service.deleteEmpleado(id);

            response.put("code",1);
            response.put("mensaje", "Empleado eliminado correctamente");
            response.put("total",1);
            response.put("data",empleadoBuscado.get());

            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje", "Empleado NO eliminado");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

