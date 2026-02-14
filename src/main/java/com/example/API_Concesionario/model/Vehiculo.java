package com.example.API_Concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vin;

    @Column
    private String matricula;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private String version;

    @Column
    private int anio;

    @Column
    private String color;

    @Column
    private String tipo;

    @Column
    private String combustible;

    @Column
    private String transmision;

    @Column
    private int km;

    @Column
    private double precio;

    @Column
    private String estado;

    @Column (name = "fecha_entrada")
    private Date fechaEntrada;

    @Column
    private String descripcion;


    public Vehiculo(String vin, String matricula, String marca, String modelo, String version, int anio, String color, String tipo, String combustible, String transmision, int km, double precio, String estado, Date fechaEntrada, String descripcion) {
        this.vin = vin;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.version = version;
        this.anio = anio;
        this.color = color;
        this.tipo = tipo;
        this.combustible = combustible;
        this.transmision = transmision;
        this.km = km;
        this.precio = precio;
        this.estado = estado;
        this.fechaEntrada = fechaEntrada;
        this.descripcion = descripcion;
    }

    public Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getVersion() {
        return version;
    }

    public int getAnio() {
        return anio;
    }

    public String getColor() {
        return color;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public String getTransmision() {
        return transmision;
    }

    public int getKm() {
        return km;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
