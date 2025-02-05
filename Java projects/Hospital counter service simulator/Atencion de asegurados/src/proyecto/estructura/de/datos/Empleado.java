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
public class Empleado {
    private String cedula;
    private String nombre;
    private String contraseña;
    private String tipoEmpleado;
    private String observaciones;
    private String estado;

    // Constructor
    public Empleado(String cedula, String nombre, String contraseña, String tipoEmpleado, String observaciones, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipoEmpleado = tipoEmpleado;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    
    //Edita los datos personales del empleado
    public ArrayList editar_datos(String nombre, String contraseña, String tipoEmpleado, String cedula, String observaciones, String estado)
    {
        // Arreglo para almacenar los mensajes de salida
        String[] salida = new String[]{"","",""}; 
        // Iterar sobre cada persona en la lista de cuentas
        for (Empleado persona : Info_Cuentas.getCuentasEmpleados()) 
        {
            // Comprobar si la persona en la lista es el empleado actual
            if(nombre.equals(persona.getNombre()))
            {
                    // Comprobar y editar la contraseña
                    if (contraseña.length() > 4 && contraseña.length() < 21)
                    {
                        if (!persona.getContraseña().equals(contraseña) && !contraseña.equals(""))
                        {
                            persona.setContraseña(contraseña);
                            salida[0] = "correcto";
                        }
                    }
                    else 
                    {
                        salida[1] = "t";
                    }
                    // Comprobar y editar la cédula
                    if (cedula.length() == 9)
                    {
                        if (!persona.getCedula().equals(cedula) && !cedula.equals(""))
                        {
                            persona.setCedula(cedula);
                            salida[0] = "correcto";
                        }
                    }
                    else 
                    {
                        salida[2] = "t";
                    }
                    // Comprobar y editar el tipo de empleado
                    if (!persona.getTipoEmpleado().equals(tipoEmpleado) && !tipoEmpleado.equals(""))
                    {
                        persona.setTipoEmpleado(tipoEmpleado);
                        salida[0] = "correcto";
                    }
                    // Comprobar y editar el observaciones
                    if (!persona.getObservaciones().equals(observaciones) && !observaciones.equals(""))
                    {
                        persona.setObservaciones(observaciones);
                        salida[0] = "correcto";
                    }
                    // Comprobar y editar el estado
                    if (estado.equals("A") || estado.equals("I"))
                    {
                        if (!persona.getEstado().equals(estado) && !estado.equals(""))
                        {
                            persona.setEstado(estado);
                            salida[0] = "correcto";
                        }
                    }
                    else 
                    {
                        salida[3] = "t";
                    }
            }
        }
        // Crear una lista a partir del arreglo de salida y devolverla
        ArrayList<String> salida1 = new ArrayList<>(Arrays.asList(salida));
        return salida1;
    }

    // Getters and Setters
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
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
