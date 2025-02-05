package pistacarros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interfaz extends JFrame
{
//variables que contienen las imagenes de los buses
public static String 
        img0= "src/Imagenes/mapa.jpeg", 
        img1 = "src/Imagenes/busamarillo.png",  
        img2 = "src/Imagenes/busblanco.png", 
        img3 = "src/Imagenes/busazul.png",
        img4 = "src/Imagenes/busmusgo.png",
        img5 = "src/Imagenes/busnaranja.png",
        img6 = "src/Imagenes/busnegro.png",
        img7 = "src/Imagenes/busrojo.png",
        img8 = "src/Imagenes/busrosado.png",
        img9 = "src/Imagenes/busturquesa.png",
        img10 = "src/Imagenes/busverde.png";
        
//Crea los labels de los buses
public static JLabel cero = new JLabel ();
public static JLabel uno = new JLabel ();
public static JLabel dos = new JLabel();
public static JLabel tres = new JLabel();
public static JLabel cuatro = new JLabel();
public static JLabel cinco = new JLabel();
public static JLabel seis = new JLabel();
public static JLabel siete = new JLabel();
public static JLabel ocho = new JLabel();
public static JLabel nueve = new JLabel();
public static JLabel diez = new JLabel();
//panels 
JPanel controles = new JPanel ();
JPanel imagenes = new JPanel ();






public Interfaz () 
{
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout (new BorderLayout ());
//le pone los iconos a los buses
cero.setIcon (new ImageIcon (img0));
uno.setIcon (new ImageIcon (img1));
dos.setIcon (new ImageIcon (img2)); 
tres.setIcon (new ImageIcon (img3)); 
cuatro.setIcon (new ImageIcon (img4)); 
cinco.setIcon (new ImageIcon (img5)); 
seis.setIcon (new ImageIcon (img6)); 
siete.setIcon (new ImageIcon (img7)); 
ocho.setIcon (new ImageIcon (img8)); 
nueve.setIcon (new ImageIcon (img9)); 
diez.setIcon (new ImageIcon (img10)); 

imagenes.setLayout (new FlowLayout()); //pone layout al panel imagenes
//agrega los buses al panel
imagenes.add (cero);
imagenes.add (uno);
imagenes.add(dos);
imagenes.add(tres);
imagenes.add(cuatro);
imagenes.add(cinco);
imagenes.add(seis);
imagenes.add(siete);
imagenes.add(ocho);
imagenes.add(nueve);
imagenes.add(diez);



controles.setLayout(new GridLayout(2, 4)); //pone layout al panel controles


imagenes.add(cero); //agrega el mapa al panel

//añade los paneles al Jframe
add("Center", imagenes);
add("South", controles);
                 
          
                    
   }
}
        
        
                    
  

