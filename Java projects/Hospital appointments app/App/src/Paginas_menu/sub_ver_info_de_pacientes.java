/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paginas_menu;

import frontend.Info_Cuentas;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class sub_ver_info_de_pacientes extends javax.swing.JPanel {

    
    String nombre; // Almacena el nombre del paciente
    
    /**
     * Constructor de la clase que recibe el nombre del paciente como parámetro.
     * Configura y muestra la información detallada del paciente en los componentes de la interfaz.
     */
    public sub_ver_info_de_pacientes(String NOMBRE) {
        initComponents();
        this.nombre = NOMBRE;
        
        // Establece el nombre del paciente en un componente de texto
        Label_nombre.setText("Nombre: " + nombre);
        
        // Itera sobre la lista de cuentas para encontrar la información del paciente por su nombre
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) {
            if(nombre.equals(persona.get(0))) {
                // Muestra la información específica del paciente en diferentes componentes de texto
                Label_correo.setText("Correo: " + persona.get(2));
                Label_cedula.setText("Cedula: " + persona.get(3)); 
                Label_edad.setText("Edad: " + persona.get(4)); 
                Label_Pais.setText("Pais: " + persona.get(5)); 
                observaciones.setText(persona.get(7));
                Label_padecimiento.setText("Padecimiento: " + persona.get(8)); 
            }
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Label_correo = new javax.swing.JLabel();
        Label_cedula = new javax.swing.JLabel();
        Label_edad = new javax.swing.JLabel();
        Label_Observaciones = new javax.swing.JLabel();
        Label_Pais = new javax.swing.JLabel();
        hacer_observacion = new javax.swing.JPanel();
        hacer_observacion_txt = new javax.swing.JLabel();
        observaciones = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Label_nombre = new javax.swing.JLabel();
        Label_padecimiento = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 255, 255));

        Label_correo.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_correo.setText("Correo:");

        Label_cedula.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_cedula.setText("Cedula:");

        Label_edad.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_edad.setText("Edad: ");

        Label_Observaciones.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_Observaciones.setText("Observaciones:");

        Label_Pais.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_Pais.setText("Pais:");

        hacer_observacion.setBackground(new java.awt.Color(64, 153, 167));
        hacer_observacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        hacer_observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hacer_observacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hacer_observacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hacer_observacionMouseExited(evt);
            }
        });

        hacer_observacion_txt.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        hacer_observacion_txt.setForeground(new java.awt.Color(255, 255, 255));
        hacer_observacion_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hacer_observacion_txt.setText("Hacer Observacion");

        javax.swing.GroupLayout hacer_observacionLayout = new javax.swing.GroupLayout(hacer_observacion);
        hacer_observacion.setLayout(hacer_observacionLayout);
        hacer_observacionLayout.setHorizontalGroup(
            hacer_observacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hacer_observacion_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        hacer_observacionLayout.setVerticalGroup(
            hacer_observacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hacer_observacion_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        observaciones.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        observaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                observacionesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        jLabel2.setText("Datos del paciente");

        Label_nombre.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_nombre.setText("Nombre:");

        Label_padecimiento.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Label_padecimiento.setText("Padecimiento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Observaciones)
                    .addComponent(hacer_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label_correo)
                            .addComponent(Label_nombre)
                            .addComponent(Label_cedula)
                            .addComponent(Label_edad)
                            .addComponent(Label_Pais)
                            .addComponent(Label_padecimiento))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addComponent(Label_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_correo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_cedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_edad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Pais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_padecimiento)
                .addGap(42, 42, 42)
                .addComponent(Label_Observaciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hacer_observacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void hacer_observacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacer_observacionMouseEntered
        Color color1 = new Color (64,130,142);
        hacer_observacion.setBackground(color1);
    }//GEN-LAST:event_hacer_observacionMouseEntered

    private void hacer_observacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacer_observacionMouseExited
        Color color2 = new Color (64,153,167);
        hacer_observacion.setBackground(color2);
    }//GEN-LAST:event_hacer_observacionMouseExited

    private void hacer_observacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hacer_observacionMouseClicked
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) 
        {
            if(nombre.equals(persona.get(0)))
            {
                persona.set(7, observaciones.getText());
            }
        
        }  
        
    }//GEN-LAST:event_hacer_observacionMouseClicked

    private void observacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_observacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_observacionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Observaciones;
    private javax.swing.JLabel Label_Pais;
    private javax.swing.JLabel Label_cedula;
    private javax.swing.JLabel Label_correo;
    private javax.swing.JLabel Label_edad;
    private javax.swing.JLabel Label_nombre;
    private javax.swing.JLabel Label_padecimiento;
    private javax.swing.JPanel hacer_observacion;
    private javax.swing.JLabel hacer_observacion_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField observaciones;
    // End of variables declaration//GEN-END:variables
}
