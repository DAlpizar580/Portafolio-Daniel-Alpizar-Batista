package pistacarros;

import java.io.IOException;


public class Main {
public static void main(String[] args) throws InterruptedException, IOException 
    {
        //Inicializa la interfaz grafica
        Interfaz ventana = new Interfaz();
        ventana.setSize(550,540);  
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("ruta buses");
        ventana.setVisible(true);
        //inicia el servidor
        Servidor servidor = new Servidor();
        servidor.start();
    }
    
}
