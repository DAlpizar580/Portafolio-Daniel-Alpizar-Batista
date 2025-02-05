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
import proyecto.estructura.de.datos.Empleado;
import proyecto.estructura.de.datos.Info_Cuentas;

/**
 *
 * @author Daniel
 */
public class modificar_empleados extends javax.swing.JPanel {

    
    public modificar_empleados() {
        initComponents();
        for (Empleado persona : Info_Cuentas.getCuentasEmpleados())
        {
            empleados.addItem(persona.getNombre());
        }
        txt_field_nombre.setText("Ingrese el nombre"); 
        txt_field_cedula.setText("Ingrese la cedula"); 
        txt_field_contraseña.setText("Ingrese la contraseña"); 
        txt_field_tipo_empeado.setText("Ingrese el tipo de empleado"); 
        txt_field_años_observaciones.setText("Ingrese las observaciones"); 
        txt_field_estado.setText("Ingrese el estado");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        Label_tipo_empleado = new javax.swing.JLabel();
        Label_cedula = new javax.swing.JLabel();
        Label_edad = new javax.swing.JLabel();
        Label_direccion = new javax.swing.JLabel();
        Label_cajero = new javax.swing.JLabel();
        Label_nombre = new javax.swing.JLabel();
        Label_telefono = new javax.swing.JLabel();
        txt_field_nombre = new javax.swing.JTextField();
        txt_field_cedula = new javax.swing.JTextField();
        txt_field_contraseña = new javax.swing.JTextField();
        txt_field_tipo_empeado = new javax.swing.JTextField();
        txt_field_años_observaciones = new javax.swing.JTextField();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        info_editada = new javax.swing.JLabel();
        error_cedula = new javax.swing.JLabel();
        txt_field_estado = new javax.swing.JTextField();
        empleados = new javax.swing.JComboBox<>();
        doctor_eliminado = new javax.swing.JLabel();
        Panel_botonEliminar = new javax.swing.JPanel();
        Label_boton10 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        Label_tipo_empleado.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_tipo_empleado.setText("Tipo de empleado:");

        Label_cedula.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_cedula.setText("Cedula:");

        Label_edad.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_edad.setText("Contraseña: ");

        Label_direccion.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_direccion.setText("Observaciones:");

        Label_cajero.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        Label_cajero.setText("Ingrese los datos");

        Label_nombre.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_nombre.setText("Nombre:");

        Label_telefono.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_telefono.setText("Estado:");

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

        txt_field_tipo_empeado.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_tipo_empeado.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_tipo_empeado.setText("contraseña");
        txt_field_tipo_empeado.setBorder(null);
        txt_field_tipo_empeado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_tipo_empeadoMousePressed(evt);
            }
        });

        txt_field_años_observaciones.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_años_observaciones.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_años_observaciones.setText("contraseña");
        txt_field_años_observaciones.setBorder(null);
        txt_field_años_observaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_años_observacionesMousePressed(evt);
            }
        });
        txt_field_años_observaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_años_observacionesKeyTyped(evt);
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
        info_editada.setText("empleado modificado");

        error_cedula.setFont(new java.awt.Font("Roboto Light", 0, 12)); // NOI18N
        error_cedula.setForeground(new java.awt.Color(255, 255, 255));
        error_cedula.setText("La cedula debe tener 9 digitos");

        txt_field_estado.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        txt_field_estado.setForeground(new java.awt.Color(204, 204, 204));
        txt_field_estado.setText("contraseña");
        txt_field_estado.setBorder(null);
        txt_field_estado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_field_estadoMousePressed(evt);
            }
        });
        txt_field_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_field_estadoKeyTyped(evt);
            }
        });

        doctor_eliminado.setBackground(new java.awt.Color(255, 255, 255));
        doctor_eliminado.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        doctor_eliminado.setForeground(new java.awt.Color(255, 255, 255));
        doctor_eliminado.setText("Empleado eliminado");

        Panel_botonEliminar.setBackground(new java.awt.Color(64, 153, 167));
        Panel_botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_botonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_botonEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_botonEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_botonEliminarMouseExited(evt);
            }
        });

        Label_boton10.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        Label_boton10.setForeground(new java.awt.Color(255, 255, 255));
        Label_boton10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_boton10.setText("Eliminar doctor");

        javax.swing.GroupLayout Panel_botonEliminarLayout = new javax.swing.GroupLayout(Panel_botonEliminar);
        Panel_botonEliminar.setLayout(Panel_botonEliminarLayout);
        Panel_botonEliminarLayout.setHorizontalGroup(
            Panel_botonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_botonEliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_boton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_botonEliminarLayout.setVerticalGroup(
            Panel_botonEliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_botonEliminarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Label_boton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(txt_field_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_field_años_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Label_tipo_empleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_field_tipo_empeado, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error_cedula)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(info_editada, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctor_eliminado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(Panel_botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Label_cajero, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_cajero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(empleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
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
                    .addComponent(Label_tipo_empleado)
                    .addComponent(txt_field_tipo_empeado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_direccion)
                    .addComponent(txt_field_años_observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_telefono)
                    .addComponent(txt_field_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(error_cedula)
                    .addComponent(doctor_eliminado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(info_editada)
                    .addComponent(Panel_botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        else if (String.valueOf(txt_field_tipo_empeado.getText()).isEmpty()) {
            txt_field_tipo_empeado.setText("Ingrese el tipo de empleado");
            txt_field_tipo_empeado.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_observaciones.getText()).isEmpty()) {
            txt_field_años_observaciones.setText("Ingrese las observaciones");
            txt_field_años_observaciones.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_estado.getText()).isEmpty()) {
            txt_field_estado.setText("Ingrese el estado");
            txt_field_estado.setForeground(new Color(204, 204, 204));
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

        else if (String.valueOf(txt_field_tipo_empeado.getText()).isEmpty()) {
            txt_field_tipo_empeado.setText("Ingrese el tipo de empleado");
            txt_field_tipo_empeado.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_observaciones.getText()).isEmpty()) {
            txt_field_años_observaciones.setText("Ingrese las observaciones");
            txt_field_años_observaciones.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_estado.getText()).isEmpty()) {
            txt_field_estado.setText("Ingrese el estado");
            txt_field_estado.setForeground(new Color(204, 204, 204));
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

        else if (String.valueOf(txt_field_tipo_empeado.getText()).isEmpty()) {
            txt_field_tipo_empeado.setText("Ingrese el tipo de empleado");
            txt_field_tipo_empeado.setForeground(new Color(204, 204, 204));
        }

        else if (String.valueOf(txt_field_años_observaciones.getText()).isEmpty()) {
            txt_field_años_observaciones.setText("Ingrese las observaciones");
            txt_field_años_observaciones.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_estado.getText()).isEmpty()) {
            txt_field_estado.setText("Ingrese el estado");
            txt_field_estado.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_contraseñaMousePressed

    private void txt_field_tipo_empeadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_tipo_empeadoMousePressed
        if (String.valueOf(txt_field_tipo_empeado.getText()).equals("Ingrese el tipo de empleado")) {
            txt_field_tipo_empeado.setText("");
            txt_field_tipo_empeado.setForeground(Color.black);
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

        else if (String.valueOf(txt_field_años_observaciones.getText()).isEmpty()) {
            txt_field_años_observaciones.setText("Ingrese las observaciones");
            txt_field_años_observaciones.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_estado.getText()).isEmpty()) {
            txt_field_estado.setText("Ingrese el estado");
            txt_field_estado.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_tipo_empeadoMousePressed

    private void txt_field_años_observacionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_años_observacionesMousePressed
        if (String.valueOf(txt_field_años_observaciones.getText()).equals("Ingrese las observaciones")) {
            txt_field_años_observaciones.setText("");
            txt_field_años_observaciones.setForeground(Color.black);
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

        else if (String.valueOf(txt_field_tipo_empeado.getText()).isEmpty()) {
            txt_field_tipo_empeado.setText("Ingrese el tipo de empleado");
            txt_field_tipo_empeado.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_estado.getText()).isEmpty()) {
            txt_field_estado.setText("Ingrese el estado");
            txt_field_estado.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_años_observacionesMousePressed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked
        if (String.valueOf(txt_field_cedula.getText()).length() == 9 || String.valueOf(txt_field_cedula.getText()).equals("Ingrese la cedula"))
        {
            for(Empleado persona : Info_Cuentas.getCuentasEmpleados())
            {
                if(persona.getNombre().equals(empleados.getSelectedItem().toString()))
                {
                    if (!String.valueOf(txt_field_nombre.getText()).equals("Ingrese el nombre") && !String.valueOf(txt_field_nombre.getText()).isEmpty())
                        persona.setNombre(String.valueOf(txt_field_nombre.getText()));
                    if (!String.valueOf(txt_field_cedula.getText()).equals("Ingrese la cedula") && !String.valueOf(txt_field_cedula.getText()).isEmpty())
                        persona.setCedula(String.valueOf(txt_field_cedula.getText()));
                    if (!String.valueOf(txt_field_tipo_empeado.getText()).equals("Ingrese el tipo de empleado") && !String.valueOf(txt_field_tipo_empeado.getText()).isEmpty())
                        persona.setTipoEmpleado(String.valueOf(txt_field_tipo_empeado.getText()));
                    if (!String.valueOf(txt_field_contraseña.getText()).equals("Ingrese la contraseña") && !String.valueOf(txt_field_contraseña.getText()).isEmpty())
                        persona.setContraseña(String.valueOf(txt_field_contraseña.getText()));
                    if (!String.valueOf(txt_field_años_observaciones.getText()).equals("Ingrese las observaciones") && !String.valueOf(txt_field_años_observaciones.getText()).isEmpty())
                        persona.setObservaciones(String.valueOf(txt_field_años_observaciones.getText()));
                    if (!String.valueOf(txt_field_estado.getText()).equals("Ingrese el estado") && !String.valueOf(txt_field_estado.getText()).isEmpty())
                        persona.setEstado(String.valueOf(txt_field_estado.getText()));
                }
            }
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

    private void txt_field_años_observacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_años_observacionesKeyTyped

    }//GEN-LAST:event_txt_field_años_observacionesKeyTyped

    private void txt_field_estadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_field_estadoMousePressed
         if (String.valueOf(txt_field_estado.getText()).equals("Ingrese el estado")) {
            txt_field_estado.setText("");
            txt_field_estado.setForeground(Color.black);
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

        else if (String.valueOf(txt_field_tipo_empeado.getText()).isEmpty()) {
            txt_field_tipo_empeado.setText("Ingrese el tipo de empleado");
            txt_field_tipo_empeado.setForeground(new Color(204, 204, 204));
        }
        else if (String.valueOf(txt_field_años_observaciones.getText()).isEmpty()) {
            txt_field_años_observaciones.setText("Ingrese las observaciones");
            txt_field_años_observaciones.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txt_field_estadoMousePressed

    private void txt_field_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_field_estadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_field_estadoKeyTyped

    private void Panel_botonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonEliminarMouseClicked
        try
        {
            for(Empleado persona : Info_Cuentas.getCuentasEmpleados())
            {
                if(persona.getNombre().equals(empleados.getSelectedItem().toString()))
                {
                    Info_Cuentas.getCuentasEmpleados().remove(persona);
                    doctor_eliminado.setForeground(Color.red);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(0);
        }
    }//GEN-LAST:event_Panel_botonEliminarMouseClicked

    private void Panel_botonEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonEliminarMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_botonEliminar.setBackground(color1);
    }//GEN-LAST:event_Panel_botonEliminarMouseEntered

    private void Panel_botonEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonEliminarMouseExited
        Color color2 = new Color (64,153,167);
        Panel_botonEliminar.setBackground(color2);
    }//GEN-LAST:event_Panel_botonEliminarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_boton;
    private javax.swing.JLabel Label_boton10;
    private javax.swing.JLabel Label_cajero;
    private javax.swing.JLabel Label_cedula;
    private javax.swing.JLabel Label_direccion;
    private javax.swing.JLabel Label_edad;
    private javax.swing.JLabel Label_nombre;
    private javax.swing.JLabel Label_telefono;
    private javax.swing.JLabel Label_tipo_empleado;
    private javax.swing.JPanel Panel_boton;
    private javax.swing.JPanel Panel_botonEliminar;
    private javax.swing.JLabel doctor_eliminado;
    private javax.swing.JComboBox<String> empleados;
    private javax.swing.JLabel error_cedula;
    private javax.swing.JLabel info_editada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField txt_field_años_observaciones;
    private javax.swing.JTextField txt_field_cedula;
    private javax.swing.JTextField txt_field_contraseña;
    private javax.swing.JTextField txt_field_estado;
    private javax.swing.JTextField txt_field_nombre;
    private javax.swing.JTextField txt_field_tipo_empeado;
    // End of variables declaration//GEN-END:variables
}
