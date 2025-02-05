/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente_proyecto_final_programacion_concurrente;

import java.text.ParseException;

/**
 *
 * @author Daniel
 */
public class Main_Cliente {

    public static void main(String[] args) throws ParseException {
        //Inicia el cliente
        Recibe resive = new Recibe();
        resive.start();
        //Abre la interfaz y la inicializa
        InterfazCliente ventana = new InterfazCliente();
        ventana.initialize();
    }
    
}
