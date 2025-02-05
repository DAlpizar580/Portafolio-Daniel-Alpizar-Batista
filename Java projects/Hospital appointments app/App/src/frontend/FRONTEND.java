package frontend;

import Info.Fechas; // Importación de la clase Fechas desde el paquete Info

public class FRONTEND {
    public static void main(String[] args) {
        // Creación de una instancia de menu_principal llamada main_menu
        menu_principal main_menu = new menu_principal();

        // Inicialización de main_menu
        main_menu.initialize();

        // Inicialización de Info_Cuentas (método estático directamente, no está claro cómo se accede)
        Info_Cuentas.initialize();
    }
}