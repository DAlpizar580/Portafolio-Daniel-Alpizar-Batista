/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrames;

import JPanels.datos_inicio_sesion;
import JPanels.crear_ticket;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.WindowConstants;

/**
 *
 * @author dylanrojas
 */
public class Inicio_Sesion extends javax.swing.JFrame {

    /**
     * Creates new form menu_principal
     */
    int xMouse;
    int yMouse;
    
    public Inicio_Sesion() {
        initComponents();
        this.setLocationRelativeTo(this);
        mostrar_panel(new datos_inicio_sesion(this));
        Cursor_drag.requestFocusInWindow();
        
        SetImageLabel(Imagen, "src\\Imagenes\\Imagen menu principal.jpg");
        SetImageLabel(Logo, "src\\Imagenes\\Imagen menu principal_Logo.png");
        SetImageLabel(Logo2, "src\\Imagenes\\Imagen menu principal_Logo2.png");
        SetImageLabel(img_minimizar, "src\\Imagenes\\-.png");
        SetImageLabel(img_cerrar, "src\\Imagenes\\x.png");
        SetImageLabel(Nombre_Hospital, "src\\Imagenes\\HOSPITAL_ULACIT.png");
    }

    public void initialize()
    {
        setTitle("Main Menu");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void mostrar_panel(Component frame)
    {
        frame.setSize(620, 530); // Establece el tamaño del componente
        frame.setLocation(0, 0); // Establece la posición del componente
        panel_opciones.removeAll(); // Elimina todos los componentes del cuerpo principal
        panel_opciones.add(frame); // Agrega el componente proporcionado al cuerpo principal
        panel_opciones.revalidate(); // Revalida el cuerpo principal
        panel_opciones.repaint(); // Repinta el cuerpo principal
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Bg = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Nombre_Hospital = new javax.swing.JLabel();
        img_cerrar = new javax.swing.JLabel();
        img_minimizar = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        Barra_arriba = new javax.swing.JPanel();
        Cursor_drag = new javax.swing.JTextField();
        Logo2 = new javax.swing.JLabel();
        panel_opciones = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_inicio_sesion = new javax.swing.JPanel();
        Label_iniciar_sesion = new javax.swing.JLabel();
        panel_sacar_tickete = new javax.swing.JPanel();
        Label_crear_ticket = new javax.swing.JLabel();

        jLabel4.setText("continuar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bg.setBackground(new java.awt.Color(255, 255, 255));
        Bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen menu principal_Logo.png"))); // NOI18N
        Bg.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 140, 140));

        Nombre_Hospital.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        Nombre_Hospital.setForeground(new java.awt.Color(255, 255, 255));
        Nombre_Hospital.setText("SEGUROS ULACIT");
        Bg.add(Nombre_Hospital, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 250, 50));

        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
        img_cerrar.setText("jLabel1");
        img_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        img_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                img_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                img_cerrarMouseExited(evt);
            }
        });
        Bg.add(img_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 27, 25));

        img_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/-.png"))); // NOI18N
        img_minimizar.setText("jLabel1");
        img_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        img_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_minimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                img_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                img_minimizarMouseExited(evt);
            }
        });
        Bg.add(img_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 27, 25));

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen menu principal.jpg"))); // NOI18N
        Bg.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 390, 570));

        Barra_arriba.setBackground(new java.awt.Color(255, 255, 255));
        Barra_arriba.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Barra_arribaMouseDragged(evt);
            }
        });
        Barra_arriba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Barra_arribaMousePressed(evt);
            }
        });

        Cursor_drag.setEditable(false);
        Cursor_drag.setBackground(new java.awt.Color(255, 255, 255));
        Cursor_drag.setForeground(new java.awt.Color(255, 255, 255));
        Cursor_drag.setBorder(null);
        Cursor_drag.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout Barra_arribaLayout = new javax.swing.GroupLayout(Barra_arriba);
        Barra_arriba.setLayout(Barra_arribaLayout);
        Barra_arribaLayout.setHorizontalGroup(
            Barra_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_arribaLayout.createSequentialGroup()
                .addComponent(Cursor_drag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 836, Short.MAX_VALUE))
        );
        Barra_arribaLayout.setVerticalGroup(
            Barra_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Barra_arribaLayout.createSequentialGroup()
                .addComponent(Cursor_drag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        Bg.add(Barra_arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        Logo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen menu principal_Logo2.png"))); // NOI18N
        Logo2.setText("jLabel1");
        Bg.add(Logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 60, 60));

        panel_opciones.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        jLabel1.setText("QUE DESEA REALIZAR");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        jLabel2.setText("POR FAVOR ELIJA LA ACCION");

        javax.swing.GroupLayout panel_opcionesLayout = new javax.swing.GroupLayout(panel_opciones);
        panel_opciones.setLayout(panel_opcionesLayout);
        panel_opcionesLayout.setHorizontalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_opcionesLayout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99))
            .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_opcionesLayout.createSequentialGroup()
                    .addContainerGap(62, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(47, 47, 47)))
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel_opcionesLayout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(jLabel2)
                    .addContainerGap(259, Short.MAX_VALUE)))
        );

        Bg.add(panel_opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 510, 380));

        panel_inicio_sesion.setBackground(new java.awt.Color(204, 204, 204));
        panel_inicio_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_inicio_sesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_inicio_sesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_inicio_sesionMouseExited(evt);
            }
        });

        Label_iniciar_sesion.setBackground(new java.awt.Color(255, 255, 255));
        Label_iniciar_sesion.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        Label_iniciar_sesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_iniciar_sesion.setText("INICIAR SESIÓN");
        Label_iniciar_sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panel_inicio_sesionLayout = new javax.swing.GroupLayout(panel_inicio_sesion);
        panel_inicio_sesion.setLayout(panel_inicio_sesionLayout);
        panel_inicio_sesionLayout.setHorizontalGroup(
            panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_iniciar_sesion, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        panel_inicio_sesionLayout.setVerticalGroup(
            panel_inicio_sesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_iniciar_sesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Bg.add(panel_inicio_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 250, 50));

        panel_sacar_tickete.setBackground(new java.awt.Color(204, 204, 204));
        panel_sacar_tickete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_sacar_ticketeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel_sacar_ticketeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_sacar_ticketeMouseExited(evt);
            }
        });

        Label_crear_ticket.setFont(new java.awt.Font("Roboto Black", 1, 28)); // NOI18N
        Label_crear_ticket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_crear_ticket.setText("SACAR TIQUETE");
        Label_crear_ticket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panel_sacar_ticketeLayout = new javax.swing.GroupLayout(panel_sacar_tickete);
        panel_sacar_tickete.setLayout(panel_sacar_ticketeLayout);
        panel_sacar_ticketeLayout.setHorizontalGroup(
            panel_sacar_ticketeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_crear_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        panel_sacar_ticketeLayout.setVerticalGroup(
            panel_sacar_ticketeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_crear_ticket, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Bg.add(panel_sacar_tickete, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 260, 50));

        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Barra_arribaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Barra_arribaMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_Barra_arribaMousePressed

    private void Barra_arribaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Barra_arribaMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_Barra_arribaMouseDragged

    private void img_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_img_cerrarMouseClicked

    private void img_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseEntered
        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x_hover.png")));
        SetImageLabel(img_cerrar, "src\\Imagenes\\x_hover.png");
    }//GEN-LAST:event_img_cerrarMouseEntered

    private void img_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseExited
        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png")));
        SetImageLabel(img_cerrar, "src\\Imagenes\\x.png");
    }//GEN-LAST:event_img_cerrarMouseExited

    private void img_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseEntered
        img_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/-_hover.png")));
        SetImageLabel(img_minimizar, "src\\Imagenes\\-_hover.png");
    }//GEN-LAST:event_img_minimizarMouseEntered

    private void img_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseExited
        img_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/-.png")));
        SetImageLabel(img_minimizar, "src\\Imagenes\\-.png");
    }//GEN-LAST:event_img_minimizarMouseExited

    private void img_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseClicked
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_img_minimizarMouseClicked

    private void panel_inicio_sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_inicio_sesionMouseEntered
        // cambia boton de color al pasar por encima
        panel_inicio_sesion.setBackground(Color.gray);
    }//GEN-LAST:event_panel_inicio_sesionMouseEntered

    private void panel_inicio_sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_inicio_sesionMouseExited
        // cambia boton de color al pasar por encima
        Color color1 = new Color (204,204,204);
        panel_inicio_sesion.setBackground(color1);
    }//GEN-LAST:event_panel_inicio_sesionMouseExited

    private void panel_sacar_ticketeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_sacar_ticketeMouseEntered
        // cambia boton de color al pasar por encima
        panel_sacar_tickete.setBackground(Color.gray);
    }//GEN-LAST:event_panel_sacar_ticketeMouseEntered

    private void panel_sacar_ticketeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_sacar_ticketeMouseExited
        // cambia boton de color al pasar por encima
        Color color1 = new Color (204,204,204);
        panel_sacar_tickete.setBackground(color1);
    }//GEN-LAST:event_panel_sacar_ticketeMouseExited

    private void panel_inicio_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_inicio_sesionMouseClicked
        mostrar_panel(new datos_inicio_sesion(this));
    }//GEN-LAST:event_panel_inicio_sesionMouseClicked

    private void panel_sacar_ticketeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_sacar_ticketeMouseClicked
        mostrar_panel(new crear_ticket(this));
    }//GEN-LAST:event_panel_sacar_ticketeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio_Sesion().setVisible(true);
            }
        });
    }
    
    private void SetImageLabel (JLabel labelName, String root) 
    {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon( image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
        
    }
    
    

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra_arriba;
    private javax.swing.JPanel Bg;
    private javax.swing.JTextField Cursor_drag;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel Label_crear_ticket;
    private javax.swing.JLabel Label_iniciar_sesion;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logo2;
    private javax.swing.JLabel Nombre_Hospital;
    private javax.swing.JLabel img_cerrar;
    private javax.swing.JLabel img_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panel_inicio_sesion;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JPanel panel_sacar_tickete;
    // End of variables declaration//GEN-END:variables
}
