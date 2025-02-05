/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

import java.util.Date;

public class ExpedienteAsegurado {
    private String cedula;
    private int idExpediente;
    private String observaciones;
    private Date fecha;
    private char estado;

    // Constructor
    public ExpedienteAsegurado(String cedula, int idExpediente, String observaciones, Date fecha, char estado) {
        this.cedula = cedula;
        this.idExpediente = idExpediente;
        this.observaciones = observaciones;
        this.fecha = fecha;
        this.estado = estado;
    }

    public ExpedienteAsegurado() {
    }

    // Getters and Setters
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}

