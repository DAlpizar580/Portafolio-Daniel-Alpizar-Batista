/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Este archivo, Fechas.java, contiene la definición de la clase Fechas en el paquete Info.
 * Proporciona funcionalidades relacionadas con la manipulación y comparación de fechas.
 */

package Info;

import java.util.Calendar;

/**
 *
 * @author Daniel
 */
public class Fechas {
    // Variables para almacenar la fecha actual
    private Calendar hoy = Calendar.getInstance();
    private Calendar a = Calendar.getInstance();
    private int año = hoy.get(Calendar.YEAR);
    private int mes = hoy.get(Calendar.MONTH);
    private int dia = hoy.get(Calendar.DATE);
    
    public Fechas()
    {
        
    }
    
    //Compara la fecha actual con una fecha proporcionada.
     
    public boolean comparar(int año, int mes, int dia)
    {
        if (this.año < año)
        {
            return true;
        }
        else if (this.año > año)
        {
            return false;     
        }
        else
        {
            if (this.mes < mes)
            {
                return true;
            }
            else if (this.mes > mes)
            {
                return false;     
            }
            else
            {
                if (this.dia < dia)
                {
                    return true;
                }
                else if (this.dia > dia)
                {
                    return false;     
                }
                else
                {
                    return false; // Las fechas son iguales
                }
            }
        }
    }
    
    
    
    
}
