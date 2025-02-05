/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

import proyecto.estructura.de.datos.Asegurado;


public class NodoCola {
    private Asegurado dato;
    private NodoCola siguiente;

    public NodoCola(Asegurado dato) 
    {
        this.dato = dato;
        this.siguiente = null;
    }

    public Asegurado getDato() {
        return dato;
    }

    public void setDato(Asegurado dato) {
        this.dato = dato;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

    
}
