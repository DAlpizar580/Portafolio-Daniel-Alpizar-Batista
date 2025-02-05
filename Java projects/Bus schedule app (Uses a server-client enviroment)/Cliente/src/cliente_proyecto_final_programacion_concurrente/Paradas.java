/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente_proyecto_final_programacion_concurrente;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Paradas {
    
    //Arraylists que contienen las paradas que ha recorrido cada bus
    private static ArrayList<String> listabus1 = new ArrayList();
    private static ArrayList<String> listabus2 = new ArrayList();
    private static ArrayList<String> listabus3 = new ArrayList();
    private static ArrayList<String> listabus4 = new ArrayList();
    private static ArrayList<String> listabus5 = new ArrayList();
    private static ArrayList<String> listabus6 = new ArrayList();
    private static ArrayList<String> listabus7 = new ArrayList();
    private static ArrayList<String> listabus8 = new ArrayList();
    private static ArrayList<String> listabus9 = new ArrayList();
    private static ArrayList<String> listabus10 = new ArrayList();

    public static void añadirParada(ArrayList<String> parada)
    {
        //Este metodo divide todos los mensajes que llegan con las paradas de cada bus y los distribulle al arraylist del bus correspondiente
        if(parada.get(0).equals("bus 1"))
        {
            Paradas.listabus1.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 2"))
        {
            Paradas.listabus2.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 3"))
        {
            Paradas.listabus3.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 4"))
        {
            Paradas.listabus4.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 5"))
        {
            Paradas.listabus5.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 6"))
        {
            Paradas.listabus6.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 7"))
        {
            Paradas.listabus7.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 8"))
        {
            Paradas.listabus8.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 9"))
        {
            Paradas.listabus9.add(parada.get(1));
        }
        else if(parada.get(0).equals("bus 10"))
        {
            Paradas.listabus10.add(parada.get(1));
        }
    }
    
    //-------------------------GETTERS Y SETTERS----------------------------------
    public static ArrayList<String> getListabus1() {
        return listabus1;
    }

    public static void setListabus1(ArrayList<String> listabus1) {
        Paradas.listabus1 = listabus1;
    }

    public static ArrayList<String> getListabus2() {
        return listabus2;
    }

    public static void setListabus2(ArrayList<String> listabus2) {
        Paradas.listabus2 = listabus2;
    }

    public static ArrayList<String> getListabus3() {
        return listabus3;
    }

    public static void setListabus3(ArrayList<String> listabus3) {
        Paradas.listabus3 = listabus3;
    }

    public static ArrayList<String> getListabus4() {
        return listabus4;
    }

    public static void setListabus4(ArrayList<String> listabus4) {
        Paradas.listabus4 = listabus4;
    }

    public static ArrayList<String> getListabus5() {
        return listabus5;
    }

    public static void setListabus5(ArrayList<String> listabus5) {
        Paradas.listabus5 = listabus5;
    }

    public static ArrayList<String> getListabus6() {
        return listabus6;
    }

    public static void setListabus6(ArrayList<String> listabus6) {
        Paradas.listabus6 = listabus6;
    }

    public static ArrayList<String> getListabus7() {
        return listabus7;
    }

    public static void setListabus7(ArrayList<String> listabus7) {
        Paradas.listabus7 = listabus7;
    }

    public static ArrayList<String> getListabus8() {
        return listabus8;
    }

    public static void setListabus8(ArrayList<String> listabus8) {
        Paradas.listabus8 = listabus8;
    }

    public static ArrayList<String> getListabus9() {
        return listabus9;
    }

    public static void setListabus9(ArrayList<String> listabus9) {
        Paradas.listabus9 = listabus9;
    }

    public static ArrayList<String> getListabus10() {
        return listabus10;
    }

    public static void setListabus10(ArrayList<String> listabus10) {
        Paradas.listabus10 = listabus10;
    }

    
}
