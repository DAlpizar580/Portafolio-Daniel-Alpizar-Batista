/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JPanels;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class menu_ver_doctores extends javax.swing.JPanel {

     
     public menu_ver_doctores() {
        initComponents(); // Inicializa los componentes visuales
    }

    
    public void mostrar_panel(Component frame) {
        // Configuración del tamaño y la ubicación del componente dentro del panel
        frame.setSize(620, 530);
        frame.setLocation(0, 0); 
        
        // Elimina todos los componentes del panel actual
        Body.removeAll();
        
        // Agrega el nuevo componente al panel
        Body.add(frame);
        
        // Actualiza el panel para que muestre los cambios
        Body.revalidate();
        Body.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        Panel_ingresar = new javax.swing.JPanel();
        txt_Agendar = new javax.swing.JLabel();
        Panel_modificar = new javax.swing.JPanel();
        txt_Ver = new javax.swing.JLabel();
        Body = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(620, 530));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_ingresar.setBackground(new java.awt.Color(64, 153, 167));
        Panel_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ingresarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_ingresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_ingresarMouseExited(evt);
            }
        });

        txt_Agendar.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        txt_Agendar.setForeground(new java.awt.Color(255, 255, 255));
        txt_Agendar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Agendar.setText("Ingresar");

        javax.swing.GroupLayout Panel_ingresarLayout = new javax.swing.GroupLayout(Panel_ingresar);
        Panel_ingresar.setLayout(Panel_ingresarLayout);
        Panel_ingresarLayout.setHorizontalGroup(
            Panel_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ingresarLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(txt_Agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Panel_ingresarLayout.setVerticalGroup(
            Panel_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ingresarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_Agendar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Base.add(Panel_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        Panel_modificar.setBackground(new java.awt.Color(64, 153, 167));
        Panel_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_modificarMouseExited(evt);
            }
        });

        txt_Ver.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        txt_Ver.setForeground(new java.awt.Color(255, 255, 255));
        txt_Ver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_Ver.setText("Modificar/eliminar");

        javax.swing.GroupLayout Panel_modificarLayout = new javax.swing.GroupLayout(Panel_modificar);
        Panel_modificar.setLayout(Panel_modificarLayout);
        Panel_modificarLayout.setHorizontalGroup(
            Panel_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_modificarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_Ver, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        Panel_modificarLayout.setVerticalGroup(
            Panel_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_Ver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Base.add(Panel_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 320, 50));

        add(Base, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, -1));

        Body.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel1.setText("Elija una opcion");

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BodyLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(131, 131, 131))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 620, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void Panel_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ingresarMouseClicked
        mostrar_panel(new ingresar_doctores());
    }//GEN-LAST:event_Panel_ingresarMouseClicked

    private void Panel_ingresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ingresarMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_ingresar.setBackground(color1);
    }//GEN-LAST:event_Panel_ingresarMouseEntered

    private void Panel_ingresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ingresarMouseExited
        Color color2 = new Color (64,153,167);
        Panel_ingresar.setBackground(color2);
    }//GEN-LAST:event_Panel_ingresarMouseExited

    private void Panel_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_modificarMouseClicked
        mostrar_panel(new modificar_doctores1());
    }//GEN-LAST:event_Panel_modificarMouseClicked

    private void Panel_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_modificarMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_modificar.setBackground(color1);
    }//GEN-LAST:event_Panel_modificarMouseEntered

    private void Panel_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_modificarMouseExited
        Color color2 = new Color (64,153,167);
        Panel_modificar.setBackground(color2);
    }//GEN-LAST:event_Panel_modificarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Panel_ingresar;
    private javax.swing.JPanel Panel_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txt_Agendar;
    private javax.swing.JLabel txt_Ver;
    // End of variables declaration//GEN-END:variables
}
