/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

import JPanels.cajero1;
import JPanels.cajero2;
import JPanels.cajero3;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto.estructura.de.datos.Asegurado;

public class Cola
{

    private NodoCola inicio,fin;
    private int tama;

    public void limpiarCola()
    {
        this.inicio = this.fin = null;
        this.tama = 0;
    }

    public boolean ColaVacia()
    {
        return this.inicio == null;
    }

    public void insertar(Asegurado ele)
    {
        NodoCola nuevo = new NodoCola(ele);
        if (ColaVacia())
        {
            this.inicio=nuevo;
        }
        else
        {
            this.fin.setSiguiente(nuevo);
        }
        this.fin=nuevo;
        this.tama++;
    }

    public Asegurado eliminar()
    {
        Asegurado aux=this.inicio.getDato();
        this.inicio=this.inicio.getSiguiente();
        this.tama--;
        return aux;
    }

    public Asegurado inicioCola()
    {
        return this.inicio.getDato();
    }

    public int tamanoCola()
    {
        return this.tama;
    }

    public void mostrarCola(JPanel main, JPanel panel_cola)
    {
        Cola aux = new Cola();
        Asegurado persona;
        int i=1;
        while(!this.ColaVacia())
        {
            persona = this.eliminar();
            JLabel asegurado = new JLabel();
            asegurado.setText(i + ")  " + persona.getCedula());
            i++;
            asegurado.setFont(new java.awt.Font("Roboto Black", 1, 18));
            panel_cola.add(asegurado); // Agrega la cita al panel
            main.repaint(); // Actualiza la representación visual del panel
            main.revalidate(); // Revalida el panel para que se muestren los cambios
            aux.insertar(persona);
        }
        while (!aux.ColaVacia()) 
        {
            persona = aux.eliminar();
            this.insertar(persona);
        }
    }
    
    public Asegurado Buscar(String cedula)
    {
        Cola aux = new Cola();
        Asegurado persona;
        Asegurado encontrado = null;
        while(!this.ColaVacia())
        {
            persona = this.eliminar();
            if(persona.getCedula().equals(cedula))
            {
                encontrado = persona;
            }
            aux.insertar(persona);
        }
        while (!aux.ColaVacia()) 
        {
            persona = aux.eliminar();
            this.insertar(persona);
        }
        return encontrado;
    }
    
    public void cola_asegurados(Asegurado asegurado)
    {
        if(!cajero1.isOcupado())
        {
            cajero1.setAsegurado(asegurado);
            cajero1.setOcupado(true);
            asegurado.setEnCajero(true);
        }
        else if(!cajero2.isOcupado())
        {
            cajero2.setAsegurado(asegurado);
            cajero2.setOcupado(true);
            asegurado.setEnCajero(true);
        }
        else if(!cajero3.isOcupado())
        {
            cajero3.setAsegurado(asegurado);
            cajero3.setOcupado(true);
            asegurado.setEnCajero(true);
        }
        else
        {
            this.insertar(asegurado);
        }
    }

    public NodoCola getInicio() {
        return inicio;
    }

    public void setInicio(NodoCola inicio) {
        this.inicio = inicio;
    }

    public NodoCola getFin() {
        return fin;
    }

    public void setFin(NodoCola fin) {
        this.fin = fin;
    }

    public int getTama() {
        return tama;
    }

    public void setTama(int tama) {
        this.tama = tama;
    }

}

