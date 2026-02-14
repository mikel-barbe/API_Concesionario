package com.example.API_Concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Table (name = "ventas")
public class Venta {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "vehiculo_id")
    private int vehiculoId;

    @Column (name = "cliente_id")
    private int clienteId;

    @Column (name = "empleado_id")
    private int empleadoId;

    @Column (name = "fecha_venta")
    private Timestamp fechaVenta;

    @Column
    private double precio;

    @Column (name = "metodo_pago")
    private String metodoPago;

    @Column
    private String estado;

    @Column
    private String observaciones;

    public Venta(int vehiculoId, int clienteId, int empleadoId, Timestamp fechaVenta, double precio, String metodoPago, String estado, String observaciones) {
        this.vehiculoId = vehiculoId;
        this.clienteId = clienteId;
        this.empleadoId = empleadoId;
        this.fechaVenta = fechaVenta;
        this.precio = precio;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public Venta() {
    }

    public Long getId() {
        return id;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public Timestamp getFechaVenta() {
        return fechaVenta;
    }

    public double getPrecio() {
        return precio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public void setFechaVenta(Timestamp fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
