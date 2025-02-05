/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Este archivo, contiene la definición de la clase abstracta persona en el paquete Info.
 * La clase abstracta persona sirve como base para las clases concretas como paciente y doctor, proporcionando campos comunes y métodos abstractos para la edición de datos.
 */
package Info;

import java.util.ArrayList;

/**
 *
 * @author XPC
 */
public abstract class persona {
    // Variables de instancia para los datos personales comunes
    private String nombre;
    private String contrasena;
    private String correo;
    private String cedula;
    private String edad;
    private String pais;
    private String funcion;
    
    //constructor, de la clase persona
    public persona(String nombre, String contrasena, String correo, String cedula, String edad, String pais, String funcion)
    {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correo = correo;
        this.cedula = cedula;
        this.edad = edad;
        this.pais = pais;
        this.funcion = funcion;
    }
    
    public persona()
    {
        
    }

    public abstract ArrayList editar_datos(String nombre, String contraseña, String correo, String cedula, String edad, String pais, String a);
    // Métodos getter y setter para las variables de instancia
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
}
