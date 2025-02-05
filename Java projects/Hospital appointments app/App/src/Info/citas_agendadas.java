/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Este archivo contiene la definición de la clase citas_agendadas en el paquete Info.
 * Proporciona funcionalidades para agendar citas, comprobar disponibilidad y gestionar la lista de citas agendadas.
 */
package Info;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class citas_agendadas {
     // Lista estática que almacena las citas agendadas como ArrayLists de Strings
    private static ArrayList<ArrayList<String>> Citas = new ArrayList<>();
    //Agenda una cita con la información proporcionada.
    public String agendar_cita(int año, int mes, int dia, String hora, String doctor, String motivo, String nombre, String date)
    {
        if(!Citas.isEmpty()) // Comprobar si la lista de citas no está vacía
        {
            for (ArrayList<String> cita : Citas) // Iterar sobre cada cita en la lista
            {
                // Comprobar si la cita ya está agendada por un doctor
                if(doctor.equals(cita.get(1)) && hora.equals(cita.get(3)) && Integer.toString(dia).equals(cita.get(6)) && Integer.toString(año).equals(cita.get(4)) && Integer.toString(mes).equals(cita.get(5)))
                {
                    return "doctor";
                }
                else if (nombre.equals(cita.get(0)) && hora.equals(cita.get(3)) && Integer.toString(dia).equals(cita.get(6)) && Integer.toString(año).equals(cita.get(4)) && Integer.toString(mes).equals(cita.get(5)))
                {
                    return "paciente";
                }
            }
        }
        // Si no hay errores, agregar la nueva cita a la lista
        ArrayList<String> cita = new ArrayList<>();
        cita.add(nombre);
        cita.add(doctor);
        cita.add(motivo);
        cita.add(hora);
        cita.add(Integer.toString(año));
        cita.add(Integer.toString(mes));
        cita.add(Integer.toString(dia));
        cita.add(date);
        Citas.add(cita);
        return "disponible";
    }
    // comprueba la disponibilidad para agendar una cita
    public String comprobar_disponibilidad(int año, int mes, int dia, String hora, String doctor, String nombre)
    {
        if(!Citas.isEmpty()) // Comprobar si la lista de citas no está vacía
        {
            for (ArrayList<String> cita : Citas) 
            {
                // Comprobar si la cita ya está agendada por un doctor
                if(doctor.equals(cita.get(1)) && hora.equals(cita.get(3)) && Integer.toString(dia).equals(cita.get(6)) && Integer.toString(año).equals(cita.get(4)) && Integer.toString(mes).equals(cita.get(5)))
                {
                    return "doctor";
                }
                // Comprobar si la cita ya está agendada por un paciente
                else if (nombre.equals(cita.get(0)) && hora.equals(cita.get(3)) && Integer.toString(dia).equals(cita.get(6)) && Integer.toString(año).equals(cita.get(4)) && Integer.toString(mes).equals(cita.get(5)))
                {
                    return "paciente";
                }
            }
        }
        return "disponible"; // Si no hay errores, la cita está disponible
    }
    
    
    
    public static ArrayList<ArrayList<String>> getCitas() { //Establece la lista de citas agendadas.
        return Citas;
    }

    public static void setCitas(ArrayList<ArrayList<String>> Citas) {
        citas_agendadas.Citas = Citas;
    }
    
}
