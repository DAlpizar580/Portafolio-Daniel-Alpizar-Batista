/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanels;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import proyecto.estructura.de.datos.Asegurado;
import proyecto.estructura.de.datos.Info_Cuentas;

/**
 *
 * @author Daniel
 */
public class Fila extends javax.swing.JPanel {

    private Asegurado asegurado;
    private JPanel Body;

    public Asegurado getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(Asegurado asegurado) {
        this.asegurado = asegurado;
    }
    
    /**
     * Constructor de la clase que recibe el nombre del paciente como parámetro.
     * Configura y muestra la información detallada del paciente en los componentes de la interfaz.
     */
    public Fila(Asegurado asegurado, JPanel panel) {
        initComponents();
        this.asegurado = asegurado;
        this.Body = panel;
        // Muestra la información específica del asegurado en diferentes componentes de texto
        if(asegurado.isEnCajero())
        {
            Label_cajero.setText("Por favor digite sus datos");
            Label_nombre.setText("Nombre: " );
            Label_provincia.setText("Provincia: " );
            Label_cedula.setText("Cedula: " ); 
            Label_edad.setText("Edad: " ); 
            Label_direccion.setText("Direccion: " ); 
            Label_telefono.setText("Telefono: " ); 
            txt_field_nombre.setText("Ingrese su nombre"); 
            txt_field_edad.setText("Ingrese su edad"); 
            txt_field_provincia.setText("Ingrese su provincia"); 
            txt_field_direccion.setText("Ingrese su dirección"); 
            txt_field_telefono.setText("Ingrese su teléfono"); 
        }
        else
        {
            Label_cajero.setText("Esta en fila por favor espere");
            Label_nombre.setText("");
            Label_provincia.setText("" );
            Label_cedula.setText("" ); 
            Label_edad.setText("" ); 
            Label_direccion.setText("" ); 
            Label_telefono.setText(""); 
            txt_field_nombre.setEditable(false);
            txt_field_edad.setEditable(false);
            txt_field_provincia.setEditable(false);
            txt_field_direccion.setEditable(false);
            txt_field_telefono.setEditable(false);
            txt_field_nombre.setVisible(false);
            txt_field_edad.setVisible(false);
            txt_field_provincia.setVisible(false);
            txt_field_direccion.setVisible(false);
            txt_field_telefono.setVisible(false);
            Panel_boton.setVisible(false);
            Label_boton.setVisible(false);
        }
    }
    

    public void mostrar_panel(Component frame)
    {
        frame.setSize(620, 530); // Establece el tamaño del componente
        frame.setLocation(0, 0); // Establece la posición del componente
        Body.removeAll(); // Elimina todos los componentes del cuerpo principal
        Body.add(frame); // Agrega el componente proporcionado al cuerpo principal
        Body.revalidate(); // Revalida el cuerpo principal
        Body.repaint(); // Repinta el cuerpo principal
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Label_provincia = new javax.swing.JLabel();
        Label_cedula = new javax.swing.JLabel();
        Label_edad = new javax.swing.JLabel();
        Label_direccion = new javax.swing.JLabel();
        Label_cajero = new javax.swing.JLabel();
        Label_nombre = new javax.swing.JLabel();
        Label_telefono = new javax.swing.JLabel();
        txt_field_nombre = new javax.swing.JTextField();
        txt_field_edad = new javax.swing.JTextField();
        txt_field_provincia = new javax.swing.JTextField();
        txt_field_direccion = new javax.swing.JTextField();
        txt_field_telefono = new javax.swing.JTextField();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        info_editada = new javax.swing.JLabel();
        error_edad = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        Label_provincia.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_provincia.setText("Provincia:");

        Label_cedula.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_cedula.setText("Cedula:");

        Label_edad.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_edad.setText("Edad: ");

        Label_direccion.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_direccion.setText("Direccion:");

        Label_cajero.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        Label_cajero.setText("Esta en fila por favor espere");

        Label_nombre.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_nombre.setText("Nombre:");

        Label_telefono.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_telefono.setText("Telefono:");

        txt_field_nombre.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_nombre.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_nombre.setText("contraseña");
        txt_field_nombre.setBorder(null);
        txt_field_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_nombreMousePressed(evt);
            }
        });

        txt_field_edad.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_edad.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_edad.setText("contraseña");
        txt_field_edad.setBorder(null);
        txt_field_edad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_edadMousePressed(evt);
            }
        });
        txt_field_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_edadKeyTyped(evt);
            }
        });

        txt_field_provincia.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_provincia.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_provincia.setText("contraseña");
        txt_field_provincia.setBorder(null);
        txt_field_provincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_provinciaMousePressed(evt);
            }
        });

        txt_field_direccion.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_direccion.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_direccion.setText("contraseña");
        txt_field_direccion.setBorder(null);
        txt_field_direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_direccionMousePressed(evt);
            }
        });

        txt_field_telefono.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_telefono.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_telefono.setText("contraseña");
        txt_field_telefono.setBorder(null);
        txt_field_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_telefonoMousePressed(evt);
            }
        });
        txt_field_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_telefonoKeyTyped(evt);
            }
        });

        Panel_boton.setBackground(new java.awt.Color(64, 153, 167));
        Panel_boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_botonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_botonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_botonMouseExited(evt);
            }
        });

        Label_boton.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        Label_boton.setForeground(new java.awt.Color(255, 255, 255));
        Label_boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_boton.setText("Guardar cambios");

        javax.swing.GroupLayout Panel_botonLayout = new javax.swing.GroupLayout(Panel_boton);
        Panel_boton.setLayout(Panel_botonLayout);
        Panel_botonLayout.setHorizontalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_boton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        );
        Panel_botonLayout.setVerticalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_botonLayout.createSequentialGroup()
                .addComponent(Label_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        info_editada.setBackground(new java.awt.Color(255, 255, 255));
        info_editada.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        info_editada.setForeground(new java.awt.Color(255, 255, 255));
        info_editada.setText("Informacion editada");

        error_edad.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        error_edad.setForeground(new java.awt.Color(255, 255, 255));
        error_edad.setText("La edad debe ser mayor a 1 y menor a 123");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_cajero, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(error_edad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(info_editada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_provincia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_field_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_field_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_telefono)
                        .addGap(18, 18, 18)
                        .addComponent(txt_field_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_edad)
                        .addGap(51, 51, 51)
                        .addComponent(txt_field_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_cedula)
                            .addComponent(Label_nombre))
                        .addGap(25, 25, 25)
                        .addComponent(txt_field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Label_cajero, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_nombre)
                    .addComponent(txt_field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Label_cedula)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_edad)
                    .addComponent(txt_field_edad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_provincia)
                    .addComponent(txt_field_provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_direccion)
                    .addComponent(txt_field_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_telefono)
                    .addComponent(txt_field_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(error_edad)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info_editada))
                .addGap(36, 36, 36))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_field_nombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_nombreMousePressed
        if (String.valueOf(txt_field_nombre.getText()).equals("Ingrese su nombre")) {
            txt_field_nombre.setText("");
            txt_field_nombre.setForeground(Color.black);
        }
        if (String.valueOf(txt_field_edad.getText()).isEmpty())
        {
            txt_field_edad.setText("Ingrese su edad");
            txt_field_edad.setForeground(new Color(204,204,204));
        }
        else if (String.valueOf(txt_field_provincia.getText()).isEmpty()) {
            txt_field_provincia.setText("Ingrese su provincia");
            txt_field_provincia.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_direccion.getText()).isEmpty()) {
            txt_field_direccion.setText("Ingrese su dirección");
            txt_field_direccion.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_telefono.getText()).isEmpty()) {
            txt_field_telefono.setText("Ingrese su teléfono");
            txt_field_telefono.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_nombreMousePressed

    private void txt_field_edadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_edadMousePressed
        if (String.valueOf(txt_field_edad.getText()).equals("Ingrese su edad")) {
            txt_field_edad.setText("");
            txt_field_edad.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese su nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_provincia.getText()).isEmpty()) {
            txt_field_provincia.setText("Ingrese su provincia");
            txt_field_provincia.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_direccion.getText()).isEmpty()) {
            txt_field_direccion.setText("Ingrese su dirección");
            txt_field_direccion.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_telefono.getText()).isEmpty()) {
            txt_field_telefono.setText("Ingrese su teléfono");
            txt_field_telefono.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_edadMousePressed

    private void txt_field_provinciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_provinciaMousePressed
        if (String.valueOf(txt_field_provincia.getText()).equals("Ingrese su provincia")) {
            txt_field_provincia.setText("");
            txt_field_provincia.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese su nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_edad.getText()).isEmpty()) {
            txt_field_edad.setText("Ingrese su edad");
            txt_field_edad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_direccion.getText()).isEmpty()) {
            txt_field_direccion.setText("Ingrese su dirección");
            txt_field_direccion.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_telefono.getText()).isEmpty()) {
            txt_field_telefono.setText("Ingrese su teléfono");
            txt_field_telefono.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_provinciaMousePressed

    private void txt_field_direccionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_direccionMousePressed
        if (String.valueOf(txt_field_direccion.getText()).equals("Ingrese su dirección")) {
            txt_field_direccion.setText("");
            txt_field_direccion.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese su nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_edad.getText()).isEmpty()) {
            txt_field_edad.setText("Ingrese su edad");
            txt_field_edad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_provincia.getText()).isEmpty()) {
            txt_field_provincia.setText("Ingrese su provincia");
            txt_field_provincia.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_telefono.getText()).isEmpty()) {
            txt_field_telefono.setText("Ingrese su teléfono");
            txt_field_telefono.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_direccionMousePressed

    private void txt_field_telefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_telefonoMousePressed
        if (String.valueOf(txt_field_telefono.getText()).equals("Ingrese su teléfono")) {
            txt_field_telefono.setText("");
            txt_field_telefono.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese su nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_edad.getText()).isEmpty()) {
            txt_field_edad.setText("Ingrese su edad");
            txt_field_edad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_provincia.getText()).isEmpty()) {
            txt_field_provincia.setText("Ingrese su provincia");
            txt_field_provincia.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_direccion.getText()).isEmpty()) {
            txt_field_direccion.setText("Ingrese su dirección");
            txt_field_direccion.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_telefonoMousePressed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked

        String salida;
        salida = asegurado.editar_datos(txt_field_nombre.getText(), txt_field_provincia.getText(), txt_field_edad.getText(), txt_field_direccion.getText(), txt_field_telefono.getText());
        
        // Se verifica el resultado de la edición de datos
        if (salida.equals("correcto")) {
            // Si la edición fue correcta, se cambia el color del mensaje 'info_editada' a verde
            info_editada.setForeground(new Color(0,153,0));
        }
        else if(salida.equals("t"))
        {
            error_edad.setForeground(Color.red);
        }
        if (Integer.parseInt(asegurado.getEdad()) >= 60)
        {
            mostrar_panel(new datos_mayores60(asegurado));
        }
    }//GEN-LAST:event_Panel_botonMouseClicked

    private void Panel_botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_boton.setBackground(color1);
    }//GEN-LAST:event_Panel_botonMouseEntered

    private void Panel_botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseExited
        Color color2 = new Color (64,153,167);
        Panel_boton.setBackground(color2);
    }//GEN-LAST:event_Panel_botonMouseExited

    private void txt_field_edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_edadKeyTyped
        char c = evt.getKeyChar();
        // Consume el evento si el caracter ingresado no es un dígito del 0 al 9
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txt_field_edadKeyTyped

    private void txt_field_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_telefonoKeyTyped
        char c = evt.getKeyChar();
        // Consume el evento si el caracter ingresado no es un dígito del 0 al 9
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txt_field_telefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_boton;
    private javax.swing.JLabel Label_cajero;
    private javax.swing.JLabel Label_cedula;
    private javax.swing.JLabel Label_direccion;
    private javax.swing.JLabel Label_edad;
    private javax.swing.JLabel Label_nombre;
    private javax.swing.JLabel Label_provincia;
    private javax.swing.JLabel Label_telefono;
    private javax.swing.JPanel Panel_boton;
    private javax.swing.JLabel error_edad;
    private javax.swing.JLabel info_editada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txt_field_direccion;
    private javax.swing.JTextField txt_field_edad;
    private javax.swing.JTextField txt_field_nombre;
    private javax.swing.JTextField txt_field_provincia;
    private javax.swing.JTextField txt_field_telefono;
    // End of variables declaration//GEN-END:variables
}
