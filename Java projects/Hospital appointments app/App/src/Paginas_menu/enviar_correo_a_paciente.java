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
public class enviar_correo_a_paciente extends javax.swing.JPanel {

    private static String emailFrom;
    private static String passwordFrom;
    private String nombre;
    private String correo;
    private String subject;
    private String mensaje;
    private String name;
    
    Correos a = new Correos();
    
    //variable que almacena las propiedades de la configuración del envío de correo
    private Properties mProperties;
    
    //se utiliza para representar una sesión de correo electrónico
    private Session mSession;
    
    //se utiliza para representar el correo electrónico que se enviara
    private MimeMessage mCorreo;
    /**
     * Creates new form sacar_cita_pacientes
     */
    public enviar_correo_a_paciente(String NAME) {
        initComponents();
        mProperties = new Properties();
        this.name = NAME;
    }
    
    public void crearCorreo(){
        //busca quien es el que envia el correo
        if (this.name.equals("Dylan")){
            emailFrom = a.getCorreoDOC1();
            passwordFrom = a.getContraDOC1();
        }
        else if (this.name.equals("Daniel")){
            emailFrom = a.getCorreoDOC2();
            passwordFrom = a.getContraDOC2();
        }
        else {
            emailFrom = a.getCorreoDOC3();
            passwordFrom = a.getContraDOC3();
        }
        
        //codigo para conseguir el correo
        this.nombre = combobox_selector_pacientes.getSelectedItem().toString();
        
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) 
        {
            if(nombre.equals(persona.get(0)))
            {
               this.correo = persona.get(2);
            }
        }  
        
        
        //saca el subject y msg
        // .trim(); elimina cualquier espacio en blanco al inicio y final del string
        subject = txtfield_subject.getText().trim();
        mensaje = txtarea_mensaje_correo.getText().trim();
        
        
        // Simple mail transfer protocol: se usa para crear un cliente y meterse al servidor de gmail
        mProperties.put("mail.smtp.host", "smtp.gmail.com"); //Indica al programa que utilice el servidor SMTP de Gmail para enviar correos electrónicos
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // está indicando que confíe en el servidor "smtp.gmail.com"
        mProperties.setProperty("mail.smtp.starttls.enable", "true"); // abilita el uso de STARTTLS que permite la encriptación de la comunicación entre el cliente y el servidor 
        mProperties.setProperty("mail.smtp.port", "587"); // Establece el puerto del servidor SMTP
        mProperties.setProperty("mail.smtp.user",emailFrom); //decir a quien se le va a enviar el correo
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //Establece la version de TLS utilizada
        mProperties.setProperty("mail.smtp.auth", "true"); // Habilita la autenticación para el servidor SMTP
        
        mSession = Session.getDefaultInstance(mProperties); // encapsula la configuración proporcionada en mProperties y se utilizará para establecer la conexión con el servidor de correo.
        
        try {
            mCorreo = new MimeMessage(mSession); //crea una instancia de MimeMessage utilizando la sesion creada previamente e mSession
            mCorreo.setFrom(new InternetAddress(emailFrom)); // Establece la dirección de correo electrónico de la persona que lo envia
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correo)); //Establece el destinatario del correo
            mCorreo.setSubject(subject); //Establece el asunto del correo
            mCorreo.setText(mensaje, "ISO-8859-1", "html"); //Establece el contenido del cuerpo del correo y indica el conjunto de caracteres y el formato del texto 
                     
            
        } 
        //Excepcion de errores de correo electronico
        catch (AddressException ex) 
        {
            //Esta parte la puso netbeans en automatico pero el logger se utiliza para registrar información detallada sobre la excepción.
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //Exceocion relacionada con el envío de mensajes
        catch (MessagingException ex) 
        {
            //Esta parte la puso netbeans en automatico pero el logger se utiliza para registrar información detallada sobre la excepción.
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EnviarCorreo(){
        try 
        {
            if (!subject.isEmpty() && !mensaje.isEmpty())
            {
                Transport mTransport = mSession.getTransport("smtp"); //crea una instancia de la clase transport que se utiliza para enviar mensajes a través de protocolos de transporte
                mTransport.connect(emailFrom, passwordFrom); //se establece una conexion con el servidor utilizando las credenciales del que envia el correo
                mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO)); //se envia el correo
                mTransport.close(); //cierra la conexión con el servidor
                JOptionPane.showMessageDialog(null, "Correo enviado"); //mensaje de correo enviado
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
        combobox_selector_pacientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtarea_mensaje_correo = new javax.swing.JTextArea();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(620, 530));
        setRequestFocusEnabled(false);

        jLabel1.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Enviar Correo a Paciente");
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

        combobox_selector_pacientes.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        combobox_selector_pacientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Emma", "Rosa", "Isaac" }));
        combobox_selector_pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobox_selector_pacientesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel4.setText("To:");

        txtarea_mensaje_correo.setColumns(20);
        txtarea_mensaje_correo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtarea_mensaje_correo.setRows(5);
        txtarea_mensaje_correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtarea_mensaje_correoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtarea_mensaje_correo);

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
            .addComponent(Label_boton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        error.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        error.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(txtfield_subject)
                        .addComponent(jLabel2)
                        .addComponent(combobox_selector_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(66, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(combobox_selector_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtfield_subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtfield_subjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfield_subjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfield_subjectActionPerformed

    private void combobox_selector_pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobox_selector_pacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_selector_pacientesActionPerformed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked
        //llama a los metodos de enviar correo
        crearCorreo();
        EnviarCorreo();
    }//GEN-LAST:event_Panel_botonMouseClicked

    private void Panel_botonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseEntered
        // cambia boton de color al pasar por encima
        Color color1 = new Color (64,130,142);
        Panel_boton.setBackground(color1);
    }//GEN-LAST:event_Panel_botonMouseEntered

    private void Panel_botonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseExited
        //devuelve boton al color original
        Color color2 = new Color (64,153,167);
        Panel_boton.setBackground(color2);
    }//GEN-LAST:event_Panel_botonMouseExited

    private void txtfield_subjectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtfield_subjectMousePressed
        error.setText("");
    }//GEN-LAST:event_txtfield_subjectMousePressed

    private void txtarea_mensaje_correoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtarea_mensaje_correoMousePressed
        error.setText("");
    }//GEN-LAST:event_txtarea_mensaje_correoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_boton;
    private javax.swing.JPanel Panel_boton;
    private javax.swing.JComboBox<String> combobox_selector_pacientes;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea_mensaje_correo;
    private javax.swing.JTextField txtfield_subject;
    // End of variables declaration//GEN-END:variables
}
