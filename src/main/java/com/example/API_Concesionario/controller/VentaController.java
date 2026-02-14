package com.example.API_Concesionario.controller;

import com.example.API_Concesionario.model.Vehiculo;
import com.example.API_Concesionario.model.Venta;
import com.example.API_Concesionario.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping
    public ResponseEntity<?> getAllVentas(){
        Map<String,Object> response = new HashMap<>();
        try {
            List<Venta> lista = service.findAll();
            response.put("code",1);
            response.put("mensaje","Lista de ventas obtenida correctamente");
            response.put("total",lista.size());
            response.put("data",lista);

            return ResponseEntity.ok(response);

        }catch (Exception e){
            response.put("code",2);
            response.put("mensaje", "Lista de ventas no obtenida: " + e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Venta> venta = service.findById(id);

        if (venta.isPresent()){
            response.put("code",1);
            response.put("mensaje", "Venta obtenida");
            response.put("total",1);
            response.put("data", venta.get());
            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje", "No existe la venta");
            response.put("total",0);
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @PostMapping
    public ResponseEntity<?> createVenta(@RequestBody Venta venta){
        Map<String,Object> response = new HashMap<>();

        try{
            Venta ventaCreada = service.createVenta(venta);
            response.put("code",1);
            response.put("mensaje","Venta creada correctamente");
            response.put("total",1);
            response.put("data",ventaCreada);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch(Exception e){
            response.put("code",2);
            response.put("mensaje","Error en la creacion de la venta");
            response.put("total",0);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable Long id, @RequestBody Venta venta){
        Map<String,Object> response = new HashMap<>();
        Optional<Venta> ventaBusqueda = service.findById(id);

        if(ventaBusqueda.isPresent()){
            Venta ventaEncontrada = ventaBusqueda.get();
            ventaEncontrada.setClienteId(venta.getClienteId());
            ventaEncontrada.setEmpleadoId(venta.getEmpleadoId());
            ventaEncontrada.setVehiculoId(venta.getVehiculoId());
            ventaEncontrada.setEstado(venta.getEstado());
            ventaEncontrada.setFechaVenta(venta.getFechaVenta());
            ventaEncontrada.setMetodoPago(venta.getMetodoPago());
            ventaEncontrada.setPrecio(venta.getPrecio());
            ventaEncontrada.setObservaciones(venta.getObservaciones());

            Venta ventaActualizada = service.updateVenta(ventaEncontrada);

            response.put("code",1);
            response.put("mensaje","Venta actualizada correctamente");
            response.put("total",1);
            response.put("data",ventaActualizada);
            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Error de ejecucion, revisa si el ID de venta existe");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Long id){
        Map<String,Object> response = new HashMap<>();
        Optional<Venta> ventaBusqueda = service.findById(id);

        if(ventaBusqueda.isPresent()){
            service.deleteVenta(id);
            response.put("code",1);
            response.put("mensaje","Venta Nº: " + id + " eliminada correctamente");
            response.put("total",1);
            response.put("data",ventaBusqueda.get());
            return ResponseEntity.ok(response);
        }else{
            response.put("code",2);
            response.put("mensaje","Venta Nº: " + id + " no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
