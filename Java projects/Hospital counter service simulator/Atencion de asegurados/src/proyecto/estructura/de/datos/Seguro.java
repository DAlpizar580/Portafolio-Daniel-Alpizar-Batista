/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

/**
 *
 * @author Daniel
 */
public class Seguro {
    private int idSeguro;
    private String descripcion;
    private char estado;
    private double monto;
    private String observaciones;

    // Constructor
    public Seguro(int idSeguro, String descripcion, char estado, double monto, String observaciones) {
        this.idSeguro = idSeguro;
        this.descripcion = descripcion;
        this.estado = estado;
        this.monto = monto;
        this.observaciones = observaciones;
    }

    // Getters and Setters
    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}

