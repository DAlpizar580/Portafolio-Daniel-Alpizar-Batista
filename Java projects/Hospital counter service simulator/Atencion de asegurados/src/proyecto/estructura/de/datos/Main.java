/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.estructura.de.datos;

import JFrames.Inicio_Sesion;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creación de una instancia de menu_principal llamada main_menu
        Inicio_Sesion main_menu = new Inicio_Sesion();

        // Inicialización de main_menu
        main_menu.initialize();

        // Inicialización de Info_Cuentas (método estático directamente, no está claro cómo se accede)
        Info_Cuentas.initialize();
    }
    
}
