/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanels;

import JFrames.menu_asegurados;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import proyecto.estructura.de.datos.Asegurado;
import proyecto.estructura.de.datos.Doctor;
import proyecto.estructura.de.datos.Info_Cuentas;

/**
 *
 * @author Daniel
 */
public class ingresar_doctores extends javax.swing.JPanel {

    
    public ingresar_doctores() {
        initComponents();
        txt_field_nombre.setText("Ingrese el nombre"); 
        txt_field_cedula.setText("Ingrese la cedula"); 
        txt_field_contraseña.setText("Ingrese la contraseña"); 
        txt_field_especialidad.setText("Ingrese la especialidad"); 
        txt_field_años_experiencia.setText("Ingrese los años de experiencia"); 
        txt_field_titulo.setText("Ingrese el titulo");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        Label_provincia = new javax.swing.JLabel();
        Label_cedula = new javax.swing.JLabel();
        Label_edad = new javax.swing.JLabel();
        Label_direccion = new javax.swing.JLabel();
        Label_cajero = new javax.swing.JLabel();
        Label_nombre = new javax.swing.JLabel();
        Label_telefono = new javax.swing.JLabel();
        txt_field_nombre = new javax.swing.JTextField();
        txt_field_cedula = new javax.swing.JTextField();
        txt_field_contraseña = new javax.swing.JTextField();
        txt_field_especialidad = new javax.swing.JTextField();
        txt_field_años_experiencia = new javax.swing.JTextField();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        info_editada = new javax.swing.JLabel();
        error_cedula = new javax.swing.JLabel();
        txt_field_titulo = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        Label_provincia.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_provincia.setText("Especialidad:");

        Label_cedula.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_cedula.setText("Cedula:");

        Label_edad.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_edad.setText("Contraseña: ");

        Label_direccion.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_direccion.setText("Años de experiencia:");

        Label_cajero.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        Label_cajero.setText("Ingrese los datos");

        Label_nombre.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_nombre.setText("Nombre:");

        Label_telefono.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_telefono.setText("Titulo:");

        txt_field_nombre.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_nombre.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_nombre.setText("contraseña");
        txt_field_nombre.setBorder(null);
        txt_field_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_nombreMousePressed(evt);
            }
        });

        txt_field_cedula.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_cedula.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_cedula.setText("contraseña");
        txt_field_cedula.setBorder(null);
        txt_field_cedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_cedulaMousePressed(evt);
            }
        });
        txt_field_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_cedulaKeyTyped(evt);
            }
        });

        txt_field_contraseña.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_contraseña.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_contraseña.setText("contraseña");
        txt_field_contraseña.setBorder(null);
        txt_field_contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_contraseñaMousePressed(evt);
            }
        });

        txt_field_especialidad.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_especialidad.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_especialidad.setText("contraseña");
        txt_field_especialidad.setBorder(null);
        txt_field_especialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_especialidadMousePressed(evt);
            }
        });

        txt_field_años_experiencia.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_años_experiencia.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_años_experiencia.setText("contraseña");
        txt_field_años_experiencia.setBorder(null);
        txt_field_años_experiencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_años_experienciaMousePressed(evt);
            }
        });
        txt_field_años_experiencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_años_experienciaKeyTyped(evt);
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
        info_editada.setText("Doctor añadido");

        error_cedula.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        error_cedula.setForeground(new java.awt.Color(255, 255, 255));
        error_cedula.setText("La cedula debe tener 9 digitos");

        txt_field_titulo.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_titulo.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_titulo.setText("contraseña");
        txt_field_titulo.setBorder(null);
        txt_field_titulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_tituloMousePressed(evt);
            }
        });
        txt_field_titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_tituloKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_provincia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_field_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_edad)
                        .addGap(18, 18, 18)
                        .addComponent(txt_field_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_cedula)
                            .addComponent(Label_nombre))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(txt_field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_field_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_telefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_field_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_field_años_experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error_cedula)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(info_editada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Label_cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_cajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_nombre)
                    .addComponent(txt_field_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_cedula)
                    .addComponent(txt_field_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_edad)
                    .addComponent(txt_field_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_provincia)
                    .addComponent(txt_field_especialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_direccion)
                    .addComponent(txt_field_años_experiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_telefono)
                    .addComponent(txt_field_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(error_cedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info_editada))
                .addGap(114, 114, 114))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_field_nombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_nombreMousePressed
        if (String.valueOf(txt_field_nombre.getText()).equals("Ingrese el nombre")) {
            txt_field_nombre.setText("");
            txt_field_nombre.setForeground(Color.black);
        }
        if (String.valueOf(txt_field_cedula.getText()).isEmpty())
        {
            txt_field_cedula.setText("Ingrese la cedula");
            txt_field_cedula.setForeground(new Color(204,204,204));
        }
        else if (String.valueOf(txt_field_contraseña.getText()).isEmpty()) {
            txt_field_contraseña.setText("Ingrese la contraseña");
            txt_field_contraseña.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_especialidad.getText()).isEmpty()) {
            txt_field_especialidad.setText("Ingrese la especialidad");
            txt_field_especialidad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_experiencia.getText()).isEmpty()) {
            txt_field_años_experiencia.setText("Ingrese los años de experiencia");
            txt_field_años_experiencia.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_titulo.getText()).isEmpty()) {
            txt_field_titulo.setText("Ingrese el titulo");
            txt_field_titulo.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_nombreMousePressed

    private void txt_field_cedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_cedulaMousePressed
        if (String.valueOf(txt_field_cedula.getText()).equals("Ingrese la cedula")) {
            txt_field_cedula.setText("");
            txt_field_cedula.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese el nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_contraseña.getText()).isEmpty()) {
            txt_field_contraseña.setText("Ingrese la contraseña");
            txt_field_contraseña.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_especialidad.getText()).isEmpty()) {
            txt_field_especialidad.setText("Ingrese la especialidad");
            txt_field_especialidad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_experiencia.getText()).isEmpty()) {
            txt_field_años_experiencia.setText("Ingrese los años de experiencia");
            txt_field_años_experiencia.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_titulo.getText()).isEmpty()) {
            txt_field_titulo.setText("Ingrese el titulo");
            txt_field_titulo.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_cedulaMousePressed

    private void txt_field_contraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_contraseñaMousePressed
        if (String.valueOf(txt_field_contraseña.getText()).equals("Ingrese la contraseña")) {
            txt_field_contraseña.setText("");
            txt_field_contraseña.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese el nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_cedula.getText()).isEmpty()) {
            txt_field_cedula.setText("Ingrese la cedula");
            txt_field_cedula.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_especialidad.getText()).isEmpty()) {
            txt_field_especialidad.setText("Ingrese la especialidad");
            txt_field_especialidad.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_experiencia.getText()).isEmpty()) {
            txt_field_años_experiencia.setText("Ingrese los años de experiencia");
            txt_field_años_experiencia.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_titulo.getText()).isEmpty()) {
            txt_field_titulo.setText("Ingrese el titulo");
            txt_field_titulo.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_contraseñaMousePressed

    private void txt_field_especialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_especialidadMousePressed
        if (String.valueOf(txt_field_especialidad.getText()).equals("Ingrese la especialidad")) {
            txt_field_especialidad.setText("");
            txt_field_especialidad.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese el nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_cedula.getText()).isEmpty()) {
            txt_field_cedula.setText("Ingrese la cedula");
            txt_field_cedula.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_contraseña.getText()).isEmpty()) {
            txt_field_contraseña.setText("Ingrese la contraseña");
            txt_field_contraseña.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_experiencia.getText()).isEmpty()) {
            txt_field_años_experiencia.setText("Ingrese los años de experiencia");
            txt_field_años_experiencia.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_titulo.getText()).isEmpty()) {
            txt_field_titulo.setText("Ingrese el titulo");
            txt_field_titulo.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_especialidadMousePressed

    private void txt_field_años_experienciaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_años_experienciaMousePressed
        if (String.valueOf(txt_field_años_experiencia.getText()).equals("Ingrese los años de experiencia")) {
            txt_field_años_experiencia.setText("");
            txt_field_años_experiencia.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese el nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_cedula.getText()).isEmpty()) {
            txt_field_cedula.setText("Ingrese la cedula");
            txt_field_cedula.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_contraseña.getText()).isEmpty()) {
            txt_field_contraseña.setText("Ingrese la contraseña");
            txt_field_contraseña.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_especialidad.getText()).isEmpty()) {
            txt_field_especialidad.setText("Ingrese la especialidad");
            txt_field_especialidad.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_titulo.getText()).isEmpty()) {
            txt_field_titulo.setText("Ingrese el titulo");
            txt_field_titulo.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_años_experienciaMousePressed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked
        if (String.valueOf(txt_field_cedula.getText()).length() == 9)
        {
            Doctor doctor = new Doctor(String.valueOf(txt_field_cedula.getText()), String.valueOf(txt_field_nombre.getText()), String.valueOf(txt_field_contraseña.getText()), String.valueOf(txt_field_especialidad.getText()), Integer.parseInt(txt_field_años_experiencia.getText()), String.valueOf(txt_field_titulo.getText()));
            Info_Cuentas.getCuentasDoctores().add(doctor);
            info_editada.setForeground(new Color(0,153,0));
        }
        else
        {
            error_cedula.setForeground(Color.red);
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

    private void txt_field_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_cedulaKeyTyped
        char c = evt.getKeyChar();
        // Consume el evento si el caracter ingresado no es un dígito del 0 al 9
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txt_field_cedulaKeyTyped

    private void txt_field_años_experienciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_años_experienciaKeyTyped
        char c = evt.getKeyChar();
        // Consume el evento si el caracter ingresado no es un dígito del 0 al 9
        if(c<'0' || c>'9') evt.consume();
    }//GEN-LAST:event_txt_field_años_experienciaKeyTyped

    private void txt_field_tituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_tituloMousePressed
         if (String.valueOf(txt_field_titulo.getText()).equals("Ingrese el titulo")) {
            txt_field_titulo.setText("");
            txt_field_titulo.setForeground(Color.black);
        }

        if (String.valueOf(txt_field_nombre.getText()).isEmpty()) {
            txt_field_nombre.setText("Ingrese el nombre");
            txt_field_nombre.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_cedula.getText()).isEmpty()) {
            txt_field_cedula.setText("Ingrese la cedula");
            txt_field_cedula.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_contraseña.getText()).isEmpty()) {
            txt_field_contraseña.setText("Ingrese la contraseña");
            txt_field_contraseña.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_especialidad.getText()).isEmpty()) {
            txt_field_especialidad.setText("Ingrese la especialidad");
            txt_field_especialidad.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_años_experiencia.getText()).isEmpty()) {
            txt_field_años_experiencia.setText("Ingrese los años de experiencia");
            txt_field_años_experiencia.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_tituloMousePressed

    private void txt_field_tituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_tituloKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_tituloKeyTyped


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
    private javax.swing.JLabel error_cedula;
    private javax.swing.JLabel info_editada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField txt_field_años_experiencia;
    private javax.swing.JTextField txt_field_cedula;
    private javax.swing.JTextField txt_field_contraseña;
    private javax.swing.JTextField txt_field_especialidad;
    private javax.swing.JTextField txt_field_nombre;
    private javax.swing.JTextField txt_field_titulo;
    // End of variables declaration//GEN-END:variables
}
