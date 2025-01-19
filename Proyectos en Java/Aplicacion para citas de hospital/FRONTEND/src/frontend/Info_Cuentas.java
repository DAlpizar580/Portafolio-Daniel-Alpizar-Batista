/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import Info.doctor;
import Info.paciente;
import java.util.ArrayList;

/**
 * Clase Info_Cuentas para almacenar cuentas de doctores y pacientes
 * Esta clase inicializa una lista de cuentas para doctores y pacientes
 * y proporciona métodos para acceder y modificar estas cuentas.
 */
public class Info_Cuentas {
    
    private static ArrayList<ArrayList<String>> Cuentas = new ArrayList<>();
    
    // Constructor vacío de la clase
    public Info_Cuentas()
    {
        
    }
   
    // Método estático para inicializar las cuentas
    public static void initialize()
    {
         // Creación de instancias de doctores y pacientes con información predefinida
         doctor doctorA = new doctor("Neurologo", "Dylan", "Dylan1234", "dylanrojas912@gmail.com", "000000000", "18", "Costa Rica", "Doctor");
         doctor doctorB = new doctor("Cirujano", "Daniel", "Daniel1234", "upfrontdev24@gmail.com", "000000001", "19", "Francia", "Doctor");
         doctor doctorC = new doctor("Radiologo", "Sebastian", "Sebastian1234", "danielalpizarb@gmail.com", "000000002", "20", "Alemania", "Doctor");
         
         paciente pacienteA = new paciente("Asma, Alergia severa al polvo","", "Emma", "Emma1234", "Ihervosoj@gmail.com", "000000003", "28", "Panama", "Paciente");
         paciente pacienteB = new paciente("Diabetes,  Obesidad","", "Rosa", "Rosa1234", "Isaachervoso1@gmail.com", "000000004", "38", "Nueva zelanda", "Paciente");
         paciente pacienteC = new paciente("Presion alta, Triglicerios altos","", "Isaac", "Isaac1234", "dsegnini04@gmail.com", "000000005", "48", "Belgica", "Paciente");
    
        // Creación de listas para almacenar la información de los pacientes y doctores
        // Se agrega la información de pacienteA a la lista paciente1
        ArrayList<String> paciente1 = new ArrayList<>();
        paciente1.add(pacienteA.getNombre());
        paciente1.add(pacienteA.getContrasena());
        paciente1.add(pacienteA.getCorreo());
        paciente1.add(pacienteA.getCedula());
        paciente1.add(pacienteA.getEdad());
        paciente1.add(pacienteA.getPais());
        paciente1.add(pacienteA.getFuncion());
        paciente1.add(pacienteA.getObservaciones());
        paciente1.add(pacienteA.getPadecimiento());
        Cuentas.add(paciente1);
        
        // Se repite el proceso para pacienteB y pacienteC
        ArrayList<String> paciente2 = new ArrayList<>();
        paciente2.add(pacienteB.getNombre());
        paciente2.add(pacienteB.getContrasena());
        paciente2.add(pacienteB.getCorreo());
        paciente2.add(pacienteB.getCedula());
        paciente2.add(pacienteB.getEdad());
        paciente2.add(pacienteB.getPais());
        paciente2.add(pacienteB.getFuncion());
        paciente2.add(pacienteB.getObservaciones());
        paciente2.add(pacienteB.getPadecimiento());
        Cuentas.add(paciente2);
        
        ArrayList<String> paciente3 = new ArrayList<>();
        paciente3.add(pacienteC.getNombre());
        paciente3.add(pacienteC.getContrasena());
        paciente3.add(pacienteC.getCorreo());
        paciente3.add(pacienteC.getCedula());
        paciente3.add(pacienteC.getEdad());
        paciente3.add(pacienteC.getPais());
        paciente3.add(pacienteC.getFuncion());
        paciente3.add(pacienteC.getObservaciones());
        paciente3.add(pacienteC.getPadecimiento());
        Cuentas.add(paciente3);
        // y para los doctores doctorA, doctorB, doctorC
        ArrayList<String> doctor1 = new ArrayList<>();
        doctor1.add(doctorA.getNombre());
        doctor1.add(doctorA.getContrasena());
        doctor1.add(doctorA.getCorreo());
        doctor1.add(doctorA.getCedula());
        doctor1.add(doctorA.getEdad());
        doctor1.add(doctorA.getPais());
        doctor1.add(doctorA.getFuncion());
        doctor1.add(doctorA.getEspecialidad());
        Cuentas.add(doctor1);
        
        ArrayList<String> doctor2 = new ArrayList<>();
        doctor2.add(doctorB.getNombre());
        doctor2.add(doctorB.getContrasena());
        doctor2.add(doctorB.getCorreo());
        doctor2.add(doctorB.getCedula());
        doctor2.add(doctorB.getEdad());
        doctor2.add(doctorB.getPais());
        doctor2.add(doctorB.getFuncion());
        doctor2.add(doctorB.getEspecialidad());
        Cuentas.add(doctor2);
        
        ArrayList<String> doctor3 = new ArrayList<>();
        doctor3.add(doctorC.getNombre());
        doctor3.add(doctorC.getContrasena());
        doctor3.add(doctorC.getCorreo());
        doctor3.add(doctorC.getCedula());
        doctor3.add(doctorC.getEdad());
        doctor3.add(doctorC.getPais());
        doctor3.add(doctorC.getFuncion());
        doctor3.add(doctorC.getEspecialidad());
        Cuentas.add(doctor3);
        // Se añaden las listas de pacientes y doctores a la lista Cuentas
    }

    // Método para obtener las cuentas
    public static ArrayList<ArrayList<String>> getCuentas() {
        return Cuentas;
    }

    // Método para establecer las cuentas
    public static void setCuentas(ArrayList<ArrayList<String>> Cuentas) {
        Info_Cuentas.Cuentas = Cuentas;
    }
}
