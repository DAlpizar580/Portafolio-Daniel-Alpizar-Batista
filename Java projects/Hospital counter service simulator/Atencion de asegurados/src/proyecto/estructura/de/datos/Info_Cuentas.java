/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.estructura.de.datos;

import estructuras_de_datos.Cola;
import estructuras_de_datos.Pila;
import java.util.ArrayList;

/**
 * Clase Info_Cuentas para almacenar cuentas 
 * Esta clase inicializa una lista de cuentas para doctores y pacientes
 * y proporciona métodos para acceder y modificar estas cuentas.
 */
public class Info_Cuentas {
    
    private static Administrador administrador = new Administrador(123456789, "Daniel", "Daniel1234", "Administrador en jefe", "Manejar las cuentas de todos los trabajadores", 'A');
    private static ArrayList<Empleado> CuentasEmpleados = new ArrayList<>();
    private static ArrayList<Doctor> CuentasDoctores = new ArrayList<>();
    private static Cola fila = new Cola();
    private static Pila pilamayores = new Pila(100);
    private static Pila pilamenores = new Pila(100);
    private static int total_atendidos = 0;
    
    // Constructor vacío de la clase
    public Info_Cuentas()
    {
        
    }
   
    // Método estático para inicializar las cuentas
    public static void initialize()
    {
         // Creación de instancias de empleados
         Empleado empleado1 = new Empleado("123456789", "Juan", "Juan1234", "Encargado cajero", "", "A");
         Empleado empleado2 = new Empleado("123456789", "Pedro", "Pedro1234", "Encargado cajero", "", "A");
         Empleado empleado3 = new Empleado("123456789", "Emma", "Emma1234", "Encargado cajero", "", "A");
         
        CuentasEmpleados.add(empleado1);
        CuentasEmpleados.add(empleado2);
        CuentasEmpleados.add(empleado3);
        
        Doctor doctor = new Doctor("123456789", "Gabriel", "Gabriel1234", "Pediatra", 30, "Medico Pediatra");
        CuentasDoctores.add(doctor);
    }

    public static Cola getFila() {
        return fila;
    }

    public static void setFila(Cola fila) {
        Info_Cuentas.fila = fila;
    }

    public static Pila getPilamayores() {
        return pilamayores;
    }

    public static void setPilamayores(Pila pilamayores) {
        Info_Cuentas.pilamayores = pilamayores;
    }

    public static Pila getPilamenores() {
        return pilamenores;
    }

    public static void setPilamenores(Pila pilamenores) {
        Info_Cuentas.pilamenores = pilamenores;
    }

    public static Administrador getAdministrador() {
        return administrador;
    }

    public static void setAdministrador(Administrador administrador) {
        Info_Cuentas.administrador = administrador;
    }

    public static ArrayList<Empleado> getCuentasEmpleados() {
        return CuentasEmpleados;
    }

    public static void setCuentasEmpleados(ArrayList<Empleado> CuentasEmpleados) {
        Info_Cuentas.CuentasEmpleados = CuentasEmpleados;
    }

    public static ArrayList<Doctor> getCuentasDoctores() {
        return CuentasDoctores;
    }

    public static void setCuentasDoctores(ArrayList<Doctor> CuentasDoctores) {
        Info_Cuentas.CuentasDoctores = CuentasDoctores;
    }

    public static int getTotal_atendidos() {
        return total_atendidos;
    }

    public static void setTotal_atendidos(int total_atendidos) {
        Info_Cuentas.total_atendidos = total_atendidos;
    }
}
