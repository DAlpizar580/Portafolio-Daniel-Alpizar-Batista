/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras_de_datos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import proyecto.estructura.de.datos.Asegurado;

public class Pila 
{
    Asegurado vectorPila[];
    int cima;
    
    
    public Pila(int tama)
    {
        vectorPila = new Asegurado[tama];
        cima = 0 ;
        
    }
    
    public void limpiarPila(int tama)
    {
        vectorPila = new Asegurado[tama];
        cima = 0 ;
        
    }
    
    public void push(Asegurado dato)
    {
        vectorPila[cima] = dato;
        cima++;
        
    }
    
    public Asegurado pop()
    {
        Asegurado eliminar = vectorPila[cima-1];
        if (cima == 0)
        {
            System.out.println("Pila vacia");
        }
        else
        {
            eliminar = vectorPila[cima-1];
            cima--;
        }
        return eliminar;
    }
    
    public int tamano()
    {
        return vectorPila.length;
        
    }
    
    public boolean pilaLlena()
    {
        if(cima == this.tamano())
        {
            return true;
            
        }
        else
        {
            return false;
        }
    }
    
    public boolean pilaVacia()
    {
        if (cima == 0)
        {
            return true;
            
        }
        else
        {
            return false;
        }
    }
    
    public void mostrarPila(JPanel main, JPanel panel_pila)
    {
        Pila pila = new Pila(tamano());
        Asegurado Var;
        int i=1;
        while (!pilaVacia())
        {
            Var = pop();
            
            JLabel asegurado = new JLabel();
            asegurado.setText(i + ")  " + Var.getCedula());
            i++;
            asegurado.setFont(new java.awt.Font("Roboto Black", 1, 18));
            panel_pila.add(asegurado); // Agrega la cita al panel
            main.repaint(); // Actualiza la representación visual del panel
            main.revalidate(); // Revalida el panel para que se muestren los cambios
            pila.push(Var);
            
        }
        while (!pila.pilaVacia())
        {
            Var = pila.pop();
            push(Var);
        }
    }

    public void invertirPila()
    {
        Pila pila = new Pila(tamano());
        Asegurado Var;
        
        while (!pilaVacia())
        {
            Var = pop();
            pila.push(Var);
            
        }
    
        while (!pila.pilaVacia())
        {
            Var = pila.pop();
            System.out.println(Var);
            push(Var);
        }
    }
    
    public Asegurado retornarcima()
    {
        Asegurado var;
        var = pop();
        push(var);
        return var;
    }
    
    public static void ordenarPila(Pila pila) {
        if (pila.pilaVacia()) {
            return; // Si la pila está vacía, no hay nada que ordenar
        }
        
        Pila pilaTemp = new Pila(pila.tamano()); // Pila temporal para almacenar elementos ordenados
        
        while (!pila.pilaVacia()) {
            Asegurado temp = pila.pop(); // Sacar un elemento de la pila original
            
            // Mover elementos mayores que el elemento temporal a la pila temporal
            while (!pilaTemp.pilaVacia() && Integer.parseInt(pilaTemp.retornarcima().getCedula()) > Integer.parseInt(temp.getCedula())) {
                pila.push(pilaTemp.pop());
            }
            
            // Insertar el elemento temporal en la posición correcta en la pila temporal
            pilaTemp.push(temp);
        }
        
        // Copiar elementos ordenados de la pila temporal a la pila original
        while (!pilaTemp.pilaVacia()) {
            pila.push(pilaTemp.pop());
        }
    }
    
}

