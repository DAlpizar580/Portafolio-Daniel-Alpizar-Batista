package pistacarros;

import java.io.DataOutputStream;
import java.net.Socket;


public class Servidor extends Thread{

    //Declaracion de variables
    private static boolean iniciado = true;
    private static boolean fin = true;
    private static int var = 0;
    int aux = var;
    private static String bus = "";
    private static String parada = "";
    private static String hora = "";
    private static String fecha = "";
    
    @Override
    public void run()
    {
        Socket socket; //variable del socket
        
        byte[] mensaje_bytes = new byte[256]; //bytes del mensaje
        
        String mensaje; //varible del mensaje

        try{
            socket = new Socket("127.0.0.1", 6000); //Conecta con el socket
            DataOutputStream out = new DataOutputStream (socket.getOutputStream()); //se almacena el paquete del mensaje que se va a enviar
            
            // Inicia el cronometro
            Cronometro_frame cron = new Cronometro_frame();
            cron.setLocationRelativeTo(null);
            cron.setTitle("cronometro");
            cron.setVisible(true);
            Cronometro_frame.getTimer().start();
            
            //Repite infinitamente buscando si hay algun mensaje para enviar
            while(fin)
            {
                Thread.sleep(250); //sleep de 0.25 seg para que no se repita tan rapido
                if(var!=aux) //valida si hay un mensaje que enviar
                {
                    //genera y envia el mensaje
                    mensaje = bus + "-" + bus + " Parada: " + parada + " Fecha: " + fecha + " " + hora;
                    out.writeUTF(mensaje);
                    aux = var;
                }
                //metodo para que inicien y terminen los buses
                if (iniciado){
                    Cronometro_frame.iniciarBuses();
                }
                if (!iniciado){
                    Cronometro_frame.terminarBuses();
                    if(iniciado)
                    {
                        mensaje = "fin del dia";
                        out.writeUTF(mensaje);
                    }
                }
            }
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    //-------------------------GETTERS Y SETTERS----------------------------------
    public static boolean isFin() {
        return fin;
    }

    public static void setFin(boolean fin) {
        Servidor.fin = fin;
    }

    public static int getVar() {
        return var;
    }

    public static void setVar(int var) {
        Servidor.var = var;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public static String getBus() {
        return bus;
    }

    public static void setBus(String bus) {
        Servidor.bus = bus;
    }

    public static String getParada() {
        return parada;
    }

    public static void setParada(String parada) {
        Servidor.parada = parada;
    }

    public static String getHora() {
        return hora;
    }

    public static void setHora(String hora) {
        Servidor.hora = hora;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        Servidor.fecha = fecha;
    }
    
    public static boolean isIniciado() {
        return iniciado;
    }

    public static void setIniciado(boolean iniciado) {
        Servidor.iniciado = iniciado;
    }
    
    
}
