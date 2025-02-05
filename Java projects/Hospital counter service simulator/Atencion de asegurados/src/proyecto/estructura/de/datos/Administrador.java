/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Daniel
 */
public class Administrador {
    private int cedula;
    private String nombre;
    private String contraseña;
    private String tipoAdministrador;
    private String funciones;
    private char estado;

    // Constructor
    public Administrador(int cedula, String nombre, String contraseña, String tipoAdministrador, String funciones, char estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoAdministrador = tipoAdministrador;
        this.funciones = funciones;
        this.estado = estado;
    }
    
    //Edita los datos personales del paciente
    public ArrayList editar_datos(String nombre, String contraseña, String correo, String cedula, String edad, String pais, String padecimiento)
    {
        return null;
    }

    // Getters and Setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAdministrador() {
        return tipoAdministrador;
    }

    public void setTipoAdministrador(String tipoAdministrador) {
        this.tipoAdministrador = tipoAdministrador;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    
}

