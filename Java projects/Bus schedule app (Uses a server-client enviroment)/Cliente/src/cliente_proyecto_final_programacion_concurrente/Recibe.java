package cliente_proyecto_final_programacion_concurrente;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;

public class Recibe extends Thread{
    
    @Override
    public void run()
    {
        ServerSocket socket; //variable del socket
        
        try 
        {
            socket = new ServerSocket(6000); //Dice cual socket se va a utilizar
            
            Socket socket_cliente = socket.accept(); //Acepta la coneccion
            
            String mensaje; //varible del mensaje
            
            DataInputStream in = new DataInputStream (socket_cliente.getInputStream()); // cariable que guarda el mensaje cuando llega
            
            do {
          mensaje = in.readUTF(); //pone el valor del mensaje a la variable de mensaje
          ArrayList<String> datos = new ArrayList<String>(); //crea el arraylist que se usa para separar el mensaje
          datos.addAll(Arrays.asList(mensaje.split("-"))); //Separa el mensaje en un arraylist
          Paradas.añadirParada(datos); //llama al metodo que añade la parada a la lista correcta
          //Genera en pantalla un jLabel con la informacion de las nuevas paradas del bus seleccionado
          if (InterfazCliente.getBus().equals(datos.get(0))) {
            JLabel parada1 = new JLabel();
            parada1.setText(datos.get(1));
            InterfazCliente.getPanel_paradas().add(parada1); 
            InterfazCliente.getPanel_paradas().repaint();
            InterfazCliente.getPanel_paradas().revalidate();
         }
         //Imprime fin del dia en todos los buses cuando se acaba el programa
         if (mensaje.equals("fin del dia"))
         {
             Paradas.getListabus1().add(mensaje);
             Paradas.getListabus2().add(mensaje);
             Paradas.getListabus3().add(mensaje);
             Paradas.getListabus4().add(mensaje);
             Paradas.getListabus5().add(mensaje);
             Paradas.getListabus6().add(mensaje);
             Paradas.getListabus7().add(mensaje);
             Paradas.getListabus8().add(mensaje);
             Paradas.getListabus9().add(mensaje);
             Paradas.getListabus10().add(mensaje);
            JLabel parada1 = new JLabel();
            parada1.setText(mensaje);
            InterfazCliente.getPanel_paradas().add(parada1);
            InterfazCliente.getPanel_paradas().repaint();
            InterfazCliente.getPanel_paradas().revalidate();
         }
        }while(1>0);
            
        } catch (Exception e) 
        {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
