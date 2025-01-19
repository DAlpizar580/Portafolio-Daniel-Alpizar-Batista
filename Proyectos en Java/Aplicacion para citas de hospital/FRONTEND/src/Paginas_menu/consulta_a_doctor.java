/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paginas_menu;

import frontend.Info_Cuentas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class consulta_a_doctor extends javax.swing.JPanel {
  
 
    // Variables que almacenan credenciales de correo electrónico
    private static String emailFrom;
    private static String passwordFrom;

    // Variables para el correo
    private String nombre;
    private String correo;
    private String subject;
    private String mensaje;
    private String name; // Variable que almacena el nombre del usuario actual

    // Propiedades y sesión para configuración del correo
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    /**
     * Constructor de la clase, recibe el nombre del usuario.
     */
    public consulta_a_doctor(String NAME) {
        initComponents();
        mProperties = new Properties();
        this.name = NAME;
    }

    // Creación de un objeto de la clase Correos
    Correos a = new Correos();

    /**
     * Método para crear el correo electrónico a enviar.
     */
    public void crearCorreo() {

        // Obtención de las credenciales de correo según el nombre del usuario
        if (this.name.equals("Emma")) {
            emailFrom = a.getCorreoPA1();
            passwordFrom = a.getContraPA1();
        } else if (this.name.equals("Rosa")) {
            emailFrom = a.getCorreoPA2();
            passwordFrom = a.getContraPA2();
        } else {
            emailFrom = a.getCorreoPA3();
            passwordFrom = a.getContraPA3();
        }

        // Código para obtener el correo del destinatario
        this.nombre = combobox_seleccionar_doctor.getSelectedItem().toString();

        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) {
            if (nombre.equals(persona.get(0))) {
                this.correo = persona.get(2);
            }
        }

        // Obtención del asunto y mensaje del correo
        subject = txtfield_subject.getText().trim();
        mensaje = txtArea_mensaje.getText().trim();

        // Configuración del protocolo SMTP para el envío del correo
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        // Inicialización de la sesión para enviar el correo
        mSession = Session.getDefaultInstance(mProperties);

        try {
            // Creación del objeto MimeMessage para el correo
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mCorreo.setSubject(subject);
            // Configuración del contenido del correo (mensaje)
            // Se indica el texto del mensaje en formato HTML
            mCorreo.setText(mensaje, "ISO-8859-1", "html");

        } catch (AddressException ex) {
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para enviar el correo electrónico.
     */
    public void EnviarCorreo() {
        try {
            if (!subject.isEmpty() && !mensaje.isEmpty())
            {
                // Establecimiento de la conexión y envío del correo
                Transport mTransport = mSession.getTransport("smtp");
                mTransport.connect(emailFrom, passwordFrom);
                mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
                mTransport.close();

                JOptionPane.showMessageDialog(null, "Correo enviado");
            }
            else
            {
                error.setForeground(Color.red);
                error.setText("El subject y el mail no pueden estar vacios");
            }
        } 
        //excepcion que indica que no se ha encontrado un proveedor para un protocolo de transporte específico
        catch (NoSuchProviderException ex) 
        {
            //netbeans pidio el try catch y puso esto automaticamente
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //excepcion que engloba muchas situaciones que pueden ocurrir durante la manipulación de mensajes
        catch (MessagingException ex) 
        {
            //netbeans pidio el try catch y puso esto automaticamente
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
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
        txtfield_subject = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combobox_seleccionar_doctor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea_mensaje = new javax.swing.JTextArea();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(620, 530));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta a Doctor");
        jLabel1.setToolTipText("");

        txtfield_subject.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtfield_subject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtfield_subjectMousePressed(evt);
            }
        });
        txtfield_subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfield_subjectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel2.setText("Subject");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel3.setText("Mail:");

        combobox_seleccionar_doctor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        combobox_seleccionar_doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dylan", "Daniel", "Sebastian" }));
        combobox_seleccionar_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_seleccionar_doctorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("To:");

        txtArea_mensaje.setColumns(20);
        txtArea_mensaje.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtArea_mensaje.setRows(5);
        txtArea_mensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtArea_mensajeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtArea_mensaje);

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
        Label_boton.setText("Enviar");

        javax.swing.GroupLayout Panel_botonLayout = new javax.swing.GroupLayout(Panel_boton);
        Panel_boton.setLayout(Panel_botonLayout);
        Panel_botonLayout.setHorizontalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_boton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        Panel_botonLayout.setVerticalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_boton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        error.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        error.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtfield_subject, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(combobox_seleccionar_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combobox_seleccionar_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfield_subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_subjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_subjectActionPerformed

    private void combobox_seleccionar_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_seleccionar_doctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_seleccionar_doctorActionPerformed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked
        crearCorreo();
        EnviarCorreo();
    }//GEN-LAST:event_Panel_botonMouseClicked

    private void Panel_botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_boton.setBackground(color1);
    }//GEN-LAST:event_Panel_botonMouseEntered

    private void Panel_botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseExited
        Color color2 = new Color (64,153,167);
        Panel_boton.setBackground(color2);
    }//GEN-LAST:event_Panel_botonMouseExited

    private void txtfield_subjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfield_subjectMousePressed
        error.setText("");
    }//GEN-LAST:event_txtfield_subjectMousePressed

    private void txtArea_mensajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtArea_mensajeMousePressed
        error.setText("");
    }//GEN-LAST:event_txtArea_mensajeMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_boton;
    private javax.swing.JPanel Panel_boton;
    private javax.swing.JComboBox<String> combobox_seleccionar_doctor;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtArea_mensaje;
    private javax.swing.JTextField txtfield_subject;
    // End of variables declaration//GEN-END:variables
}
