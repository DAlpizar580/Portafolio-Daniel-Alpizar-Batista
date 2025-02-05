package estructuras_de_datos;

import proyecto.estructura.de.datos.Asegurado;

public class nodoListaDoble {
    private Asegurado dato;
    private nodoListaDoble siguiente;
    private nodoListaDoble anterior;
    public Asegurado getDato() {
        return dato;
    }
    public void setDato(Asegurado dato) {
        this.dato = dato;
    }
    public nodoListaDoble getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(nodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }
    public nodoListaDoble getAnterior() {
        return anterior;
    }
    public void setAnterior(nodoListaDoble anterior) {
        this.anterior = anterior;
    }

    
}
