/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

import estructuras_de_datos.ListaDoble;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Doctor {
    private String cedula;
    private String nombre;
    private String contraseña;
    private String especialidad;
    private int añosExperiencia;
    private String titulo;
    private static ListaDoble pacientes = new ListaDoble();

    // Constructor
    public Doctor(String cedula, String nombre, String contraseña, String especialidad, int añosExperiencia, String titulo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
        this.titulo = titulo;
    }
    
    public static void asignar_doctor(Asegurado asegurado)
    {
         // Crear un objeto de la clase Random
        Random random = new Random();
        // Generar un número aleatorio para que se le asigne un doctor
        int num = random.nextInt(Info_Cuentas.getCuentasDoctores().size());
        Info_Cuentas.getCuentasDoctores().get(num).getPacientes().ingresar(asegurado);
    }

    // Getters and Setters

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static ListaDoble getPacientes() {
        return pacientes;
    }

    public static void setPacientes(ListaDoble pacientes) {
        Doctor.pacientes = pacientes;
    }
}

