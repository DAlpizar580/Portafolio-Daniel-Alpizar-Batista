/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Daniel
 */
public class Asegurado {
    private String cedula;
    private String nombre;
    private String edad;
    private String provincia;
    private String direccion;
    private String telefono;
    private String pariente;
    private String telpariente;
    private ExpedienteAsegurado expediente;
    private TipoSeguro tipoSeguro;
    private Seguro seguro;
    private boolean enCajero;

    // Constructor
    public Asegurado(String cedula, String nombre, String edad, String provincia, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pariente = pariente;
        this.telpariente = telpariente;
        Random random = new Random();
        int num = random.nextInt(1000000);
        Date fecha = new Date();
        this.expediente = new ExpedienteAsegurado(cedula,num,"",fecha,'A');
        this.tipoSeguro = new TipoSeguro();
    }

    //Edita los datos personales del paciente
    public String editar_datos(String nombre, String provincia, String edad, String direccion, String telefono)
    {
        String salida = "";
        // Comprobar y editar la edad
        if (!this.edad.equals(edad) && !edad.equals(""))
        {
            this.edad = edad;
            salida = "correcto";
        }
        // Comprobar y editar la provincia
        if (!this.provincia.equals(provincia) && !provincia.equals(""))
        {
            this.provincia = provincia;
            salida = "correcto";
        }
        // Comprobar y editar el nombre
        if (!this.nombre.equals(nombre) && !nombre.equals(""))
        {
            this.nombre = nombre;
            salida = "correcto";
        }
        // Comprobar y editar la direccion
        if (!this.direccion.equals(direccion) && !direccion.equals(""))
        {
            this.direccion = direccion;
            salida = "correcto";
        }
        // Comprobar y editar el telefono
        if (!this.telefono.equals(telefono) && !telefono.equals(""))
        {
            this.telefono = telefono;
            salida = "correcto";
        }
        return salida;
    }
    
    // Getters and Setters
    public boolean isEnCajero() {
        return enCajero;
    }

    public void setEnCajero(boolean enCola) {    
        this.enCajero = enCola;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPariente() {
        return pariente;
    }

    public void setPariente(String pariente) {
        this.pariente = pariente;
    }

    public String getTelpariente() {
        return telpariente;
    }

    public void setTelpariente(String telpariente) {
        this.telpariente = telpariente;
    }

    public ExpedienteAsegurado getExpediente() {
        return expediente;
    }

    public void setExpediente(ExpedienteAsegurado expediente) {
        this.expediente = expediente;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}

