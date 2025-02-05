/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Este archivo, contiene la definición de la clase paciente que extiende la clase persona en el paquete Info.
 * Proporciona funcionalidades específicas para los pacientes, como la gestión de las citas médicas, observaciones, padecimientos y la edición de datos personales.
 */
package Info;

import frontend.Info_Cuentas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author XPC
 */
public class paciente extends persona {
    // Variables de instancia para almacenar observaciones y padecimientos del paciente
    private String observaciones;
    private String padecimiento;

    
    //Obtiene el padecimiento del paciente.
    public String getPadecimiento() {
        return padecimiento;
    }
    //establece el padecimiento del paciente
    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }
    //Obtiene las observaciones sobre el paciente.
       public String getObservaciones() {
        return observaciones;
    }
    // Establece las observaciones sobre el paciente.
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    //Constructor de la clase paciente.
    public paciente(String padecimiento, String observaciones, String nombre, String contrasena, String correo, String cedula, String edad, String pais, String funcion) 
    {
        super(nombre, contrasena, correo, cedula, edad, pais, funcion);
        this.observaciones = observaciones;
        this.padecimiento = padecimiento;
    }
    
    public paciente()
    {
        
    }
    
    @Override
    //Edita los datos personales del paciente
    public ArrayList editar_datos(String nombre, String contraseña, String correo, String cedula, String edad, String pais, String padecimiento)
    {
        // Arreglo para almacenar los mensajes de salida
        String[] salida = new String[]{"","","","","",""}; 
        // Iterar sobre cada persona en la lista de cuentas
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) 
        {
            // Comprobar si la persona en la lista es el paciente actual
            if(nombre.equals(persona.get(0)))
            {
                    // Comprobar y editar la contraseña
                    if (contraseña.length() > 4 && contraseña.length() < 21)
                    {
                        if (!persona.get(1).equals(contraseña) && !contraseña.equals(""))
                        {
                            persona.set(1,contraseña);
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
                        if (!persona.get(3).equals(cedula) && !cedula.equals(""))
                        {
                            persona.set(3,cedula);
                            salida[0] = "correcto";
                        }
                    }
                    else 
                    {
                        salida[2] = "t";
                    }
                    // Comprobar y editar la edad
                    if (!edad.equals(""))
                    {
                        if(Integer.parseInt(edad) >= 1 && Integer.parseInt(edad) <= 123)
                        {
                            if (!persona.get(4).equals(edad))
                            {
                                persona.set(4,edad);
                                salida[0] = "correcto";
                            }
                        }
                        else
                        {
                            salida[3] = "t";
                        }
                    }
                    // Comprobar y editar el país
                    String[] paises = new String[]{"Afganistán","Albania","Alemania","Andorra","Angola","Antigua y Barbuda","Arabia Saudita","Argelia","Argentina","Armenia","Australia","Austria","Azerbaiyán","Bahamas","Bangladés","Barbados","Baréin","Bélgica","Belice","Benín","Bielorrusia","Birmania","Bolivia","Bosnia y Herzegovina","Botsuana","Brasil","Brunéi","Bulgaria","Burkina Faso","Burundi","Bután","Cabo Verde","Camboya","Camerún","Canadá","Catar","Chad","Chile","China","Chipre","Ciudad del Vaticano","Colombia","Comoras","Corea del Norte","Corea del Sur","Costa de Marfil","Costa Rica","Croacia","Cuba","Dinamarca","Dominica","Ecuador","Egipto","El Salvador","Emiratos Árabes Unidos","Eritrea","Eslovaquia","Eslovenia","España","Estados Unidos","Estonia","Etiopía","Filipinas","Finlandia","Fiyi","Francia","Gabón","Gambia","Georgia","Ghana","Granada","Grecia","Guatemala","Guyana","Guinea","Guinea ecuatorial","Guinea-Bisáu","Haití","Honduras","Hungría","India","Indonesia","Irak","Irán","Irlanda","Islandia","Islas Marshall","Islas Salomón","Israel","Italia","Jamaica","Japón","Jordania","Kazajistán","Kenia","Kirguistán","Kiribati","Kuwait","Laos","Lesoto","Letonia","Líbano","Liberia","Libia","Liechtenstein","Lituania","Luxemburgo","Madagascar","Malasia","Malaui","Maldivas","Malí","Malta","Marruecos","Mauricio","Mauritania","México","Micronesia","Moldavia","Mónaco","Mongolia","Montenegro","Mozambique","Namibia","Nauru","Nepal","Nicaragua","Níger","Nigeria","Noruega","Nueva Zelanda","Omán","Países Bajos","Pakistán","Palaos","Palestina","Panamá","Papúa Nueva Guinea","Paraguay","Perú","Polonia","Portugal","Reino Unido","República Centroafricana","República Checa","República de Macedonia","República del Congo","República Democrática del Congo","República Dominicana","República Sudafricana","Ruanda","Rumanía","Rusia","Samoa","San Cristóbal y Nieves","San Marino","San Vicente y las Granadinas","Santa Lucía","Santo Tomé y Príncipe","Senegal","Serbia","Seychelles","Sierra Leona","Singapur","Siria","Somalia","Sri Lanka","Suazilandia","Sudán","Sudán del Sur","Suecia","Suiza","Surinam","Tailandia","Tanzania","Tayikistán","Timor Oriental","Togo","Tonga","Trinidad y Tobago","Túnez","Turkmenistán","Turquía","Tuvalu","Ucrania","Uganda","Uruguay","Uzbekistán","Vanuatu","Venezuela","Vietnam","Yemen","Yibuti","Zambia","Zimbabue"};
                    if (Arrays.asList(paises).contains(pais))
                    {
                        if (!persona.get(5).equals(pais) && !pais.equals(""))
                        {
                            persona.set(5,pais);
                            salida[0] = "correcto";
                        }
                    }
                    else
                    {
                        salida[4] = "t";
                    }
                    // Comprobar y editar el padecimiento
                    if (!persona.get(8).equals(padecimiento) && !padecimiento.equals(""))
                    {
                        persona.set(8,padecimiento);
                        salida[0] = "correcto";
                    }
            }
        }
        // Crear una lista a partir del arreglo de salida y devolverla
        ArrayList<String> salida1 = new ArrayList<>(Arrays.asList(salida));
        return salida1;
    }

 
  
     
}
