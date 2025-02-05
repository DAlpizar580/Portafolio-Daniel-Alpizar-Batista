package estructuras_de_datos;

import JPanels.expediente;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto.estructura.de.datos.Asegurado;

public class ListaDoble {
    nodoListaDoble primero;
    nodoListaDoble ultimo;
    
    public ListaDoble(){
        primero = null;
        ultimo = null;
    }

    public boolean Vacia()
    {
        if (primero == null)
        return true;
        else
        return false;
    }

    public void ingresar(Asegurado dato){
        nodoListaDoble nodoNuevo = new nodoListaDoble();
        nodoNuevo.setDato(dato);
        if (primero == null)
        {
            primero = nodoNuevo;
            primero.setSiguiente(null);
            primero.setAnterior(null);
            ultimo = primero;
        }
        else
        {
            ultimo.setSiguiente(nodoNuevo);
            nodoNuevo.setAnterior(ultimo);
            nodoNuevo.setSiguiente(null);
            ultimo = nodoNuevo;
        }
    }

    public void ingresarInicio(Asegurado dato)
    {
        nodoListaDoble nodoNuevo = new nodoListaDoble();
        nodoNuevo.setDato(dato);
        if (primero == null)
        {
            primero = nodoNuevo;
            primero.setSiguiente(null);
            primero.setAnterior(null);
            ultimo = primero;
        }
        else
        {
            nodoNuevo.setSiguiente(primero);
            nodoNuevo.setAnterior(null);
            primero.setAnterior(nodoNuevo);
            primero = nodoNuevo;
        }
    }

    public void buscar(Asegurado dato)
    {
        nodoListaDoble actual = new nodoListaDoble();
        actual = primero;
        while (actual != null)
        {
            if (actual.getDato() == dato)
            {
                System.out.println("nodo encontrado");
            }
            actual = actual.getSiguiente();
        }
    }

    public void modificar(Asegurado dato, Asegurado nuevo)
    {
        nodoListaDoble actual = new nodoListaDoble();
        actual = primero;
        while (actual != null)
        {
            if (actual.getDato() == dato)
            {
                actual.setDato(nuevo);
                System.out.println("Se cambiaron los datos exitosamente");
            }
            actual = actual.getSiguiente();
        }
    }

    public void imprimir(JPanel main, JPanel panel_lista)
    {
        nodoListaDoble actual = new nodoListaDoble();
        actual = primero;
        while (actual != null)
        {
            expediente panelExpediente = new expediente(actual.getDato());
            panel_lista.add(panelExpediente); // Agrega la cita al panel
            main.repaint(); // Actualiza la representación visual del panel
            main.revalidate(); // Revalida el panel para que se muestren los cambios
            actual = actual.getSiguiente();
        }
    }

    public void imprimirInverso()
    {
        nodoListaDoble actual = new nodoListaDoble();
        actual = ultimo;
        while (actual != null)
        {
            System.out.println(actual.getDato());
            actual = actual.getAnterior();
        }
    }

    public void eliminar(Asegurado dato){
        nodoListaDoble actual = new nodoListaDoble();
        nodoListaDoble anterior = new nodoListaDoble();
        actual = primero;
        anterior = null;
        while (actual != null)
        {
            if (actual.getDato() == dato)
            {
                if (actual == primero)
                {
                    primero = primero.getSiguiente();
                    primero.setAnterior(null);
                }
                else
                {
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }
       

    public void mostarExtremos()
    {
        System.out.println(primero.getDato());
        System.out.println(ultimo.getDato());
    }
        
}
