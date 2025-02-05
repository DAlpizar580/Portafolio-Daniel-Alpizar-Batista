/*
 * Este archivo, contiene la definición de la clase doctor que extiende la clase persona en el paquete Info.
 * Proporciona funcionalidades específicas para los doctores, como la gestión de la especialidad y la edición de datos personales.
 */

package Info;

import frontend.Info_Cuentas;
import java.util.ArrayList;
import java.util.Arrays;

public class doctor extends persona {
     
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    // Variable de instancia para almacenar la especialidad del doctor
    private String especialidad;

    public doctor(String especialidad, String nombre, String contrasena, String correo, String cedula, String edad, String pais, String funcion) {
        super(nombre, contrasena, correo, cedula, edad, pais, funcion);
        this.especialidad = especialidad;
    }
    
    public doctor() // No se realiza ninguna acción en el constructor por defecto
    {
        
    }
    
    @Override // edita los datos personales del doctor
    public ArrayList editar_datos(String nombre, String contraseña, String correo, String cedula, String edad, String pais, String especialidad)
    {
        String[] salida = new String[]{"","","","","",""}; // Arreglo para almacenar los mensajes de salida
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) 
        {
            if(nombre.equals(persona.get(0))) // Comprobar si la persona en la lista es el doctor actual
            {
                    if (contraseña.length() > 4 && contraseña.length() < 21) // Comprobar y editar la contraseña
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
                    if (cedula.length() == 9) // Comprobar y editar la cédula
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
                    if (!edad.equals(""))  // Comprobar y editar la edad
                    {
                        if(Integer.parseInt(edad) >= 1 && Integer.parseInt(edad) <= 123)
                        {
                            if (!persona.get(4).equals(edad) && !persona.get(4).equals(""))
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
                    // Comprobar y editar la especialidad
                    if (!persona.get(7).equals(especialidad) && !especialidad.equals(""))
                    {
                        persona.set(7,especialidad);
                        salida[0] = "correcto";
                    }
            }
        }
        // Crear una lista a partir del arreglo de salida y devolverla
        ArrayList<String> salida1 = new ArrayList<>(Arrays.asList(salida));
        return salida1;
    }
  
}



