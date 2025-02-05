/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Paginas_menu;
import java.awt.Color;
import java.util.Calendar;
import Info.Fechas;
import Info.citas_agendadas;
import frontend.Info_Cuentas;
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
public class agendar_citas_pacientes extends javax.swing.JPanel {

    //variable que almacena las propiedades de la configuración del envío de correo
    private Properties mProperties;
    //se utiliza para representar una sesión de correo electrónico
    Session mSession;
    //se utiliza para representar el correo electrónico que se enviara
    private MimeMessage mCorreo;
    private String name;
    private String correo;
    /**
     * Creates new form Citas
     */
    public agendar_citas_pacientes(String name) {
        initComponents();
        mProperties = new Properties();
        this.name = name;
    }
    
    public void enviar_correo ()
    {
        String emailFrom;
        String passwordFrom;
        Correos a = new Correos();
        int año = fecha.getCalendar().get(Calendar.YEAR);
        int mes = fecha.getCalendar().get(Calendar.MONTH);
        int dia = fecha.getCalendar().get(Calendar.DATE);
        String date1 = Integer.toString(dia) + "/" + Integer.toString(mes+1) + "/" + Integer.toString(año);
        //busca quien es el que envia el correo
        if (box_doctor.getSelectedItem().toString().equals("Dylan")){
            emailFrom = a.getCorreoDOC1();
            passwordFrom = a.getContraDOC1();
        }
        else if (box_doctor.getSelectedItem().toString().equals("Daniel")){
            emailFrom = a.getCorreoDOC2();
            passwordFrom = a.getContraDOC2();
        }
        else {
            emailFrom = a.getCorreoDOC3();
            passwordFrom = a.getContraDOC3();
        }
        
        String paciente = this.name;
        
        for (ArrayList<String> persona : Info_Cuentas.getCuentas()) 
        {
            if(paciente.equals(persona.get(0)))
            {
                correo = persona.get(2);
            }
        }  
        
        //saca el subject y msg
        // .trim(); elimina cualquier espacio en blanco al inicio y final del string
        String subject = "Cita Medica";
        String cuerpo = "Confirmacion de cita medica con las siguientes especificaciones: " + "\n \n" +
                        "Nombre del paciente: " + this.name + "\n" +
                        "Nombre del doctor: " + box_doctor.getSelectedItem().toString() + "\n" +
                        "Fecha: " + date1 + "\n" +
                        "Hora: " + box_hora.getSelectedItem().toString() + "\n" +
                        "Motivo: " + txt_area_motivo.getText().trim();
        
        
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
            mCorreo.setText(cuerpo, "ISO-8859-1", "html"); //Establece el contenido del cuerpo del correo y indica el conjunto de caracteres y el formato del texto 
                     
            
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
        
        //---------------------------------------------envia el correo----------------------------------------------------------------------------------
        try 
        {
            Transport mTransport = mSession.getTransport("smtp"); //crea una instancia de la clase transport que se utiliza para enviar mensajes a través de protocolos de transporte
            mTransport.connect(emailFrom, passwordFrom); //se establece una conexion con el servidor utilizando las credenciales del que envia el correo
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO)); //se envia el correo
            mTransport.close(); //cierra la conexión con el servidor
            JOptionPane.showMessageDialog(null, "Correo enviado"); //mensaje de correo enviado
        } 
        //excepcion que indica que no se ha encontrado un proveedor para un protocolo de transporte específico
        catch (NoSuchProviderException ex) 
        {
            Logger.getLogger(enviar_correo_a_paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        //excepcion que engloba muchas situaciones que pueden ocurrir durante la manipulación de mensajes
        catch (MessagingException ex) 
        {
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

        box_doctor = new javax.swing.JComboBox<>();
        label_doctor = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        label_fecha = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        label_hora = new javax.swing.JLabel();
        box_hora = new javax.swing.JComboBox<>();
        label_motivo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area_motivo = new javax.swing.JTextArea();
        Panel_boton = new javax.swing.JPanel();
        Label_boton = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        box_doctor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        box_doctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dylan", "Daniel", "Sebastian" }));
        box_doctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                box_doctorMouseClicked(evt);
            }
        });
        box_doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_doctorActionPerformed(evt);
            }
        });

        label_doctor.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        label_doctor.setText("Doctor:");

        titulo.setFont(new java.awt.Font("Roboto Black", 1, 44)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Agendar cita con un doctor");
        titulo.setToolTipText("");

        label_fecha.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        label_fecha.setText("Fecha:");

        fecha.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMouseClicked(evt);
            }
        });

        label_hora.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        label_hora.setText("Hora:");

        box_hora.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        box_hora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8:00 AM", "9:00 AM", "10:00 AM", "11:00 AM", "12:00 PM (Mediodía)", "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM" }));
        box_hora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                box_horaMouseClicked(evt);
            }
        });
        box_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_horaActionPerformed(evt);
            }
        });

        label_motivo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        label_motivo.setText("Motivo:");

        txt_area_motivo.setColumns(20);
        txt_area_motivo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txt_area_motivo.setRows(5);
        txt_area_motivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_area_motivoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_area_motivo);

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
        Label_boton.setText("Agendar");

        javax.swing.GroupLayout Panel_botonLayout = new javax.swing.GroupLayout(Panel_boton);
        Panel_boton.setLayout(Panel_botonLayout);
        Panel_botonLayout.setHorizontalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Panel_botonLayout.setVerticalGroup(
            Panel_botonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_boton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        mensaje.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        mensaje.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensaje)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(label_motivo)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_doctor)
                                .addComponent(box_doctor, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(label_fecha)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_hora)
                                .addComponent(box_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_doctor)
                    .addComponent(label_fecha)
                    .addComponent(label_hora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(box_doctor)
                    .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(box_hora, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(label_motivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_boton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void box_doctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_doctorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_doctorActionPerformed

    private void box_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_horaActionPerformed

    private void Panel_botonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_botonMouseClicked
        // Verifica si la fecha seleccionada no es nula
if (fecha.getCalendar() != null) {
    // Obtiene el año, mes y día de la fecha seleccionada
    int año = fecha.getCalendar().get(Calendar.YEAR);
    int mes = fecha.getCalendar().get(Calendar.MONTH);
    int dia = fecha.getCalendar().get(Calendar.DATE);
    
    // Convierte la fecha a una cadena en formato día/mes/año
    String date1 = Integer.toString(dia) + "/" + Integer.toString(mes + 1) + "/" + Integer.toString(año);
    
    // Obtiene la hora, el doctor y el motivo de la cita
    String hora = box_hora.getSelectedItem().toString();
    String doctor = box_doctor.getSelectedItem().toString();
    String motivo = txt_area_motivo.getText().trim();
    
    // Instancia objetos de las clases Fechas y citas_agendadas
    Fechas date = new Fechas();
    citas_agendadas agendar = new citas_agendadas();
    
    // Verifica si la fecha seleccionada es posterior a la fecha actual
    if (date.comparar(año, mes, dia)) {
        // Intenta agendar la cita según la lógica implementada en agendar_cita
        String salida = agendar.agendar_cita(año, mes, dia, hora, doctor, motivo, this.name, date1);
        
        // Actualiza el mensaje en base al resultado del agendamiento
        switch (salida) {
            case "disponible":
                mensaje.setForeground(Color.green);
                mensaje.setText("La cita se ha agendado con éxito");
                enviar_correo();
                break;
            case "doctor":
                mensaje.setForeground(Color.red);
                mensaje.setText("El doctor está ocupado a esa hora, elige otra hora");
                break;
            case "paciente":
                mensaje.setForeground(Color.red);
                mensaje.setText("Ya tienes una cita agendada a esta hora, elige otra hora");
                break;
            default:
                break;
        }
    } else {
        // Si la fecha seleccionada es igual o anterior a la fecha actual, muestra un mensaje de error
        mensaje.setForeground(Color.red);
        mensaje.setText("No puedes elegir una fecha anterior o igual a la actual");
    }
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

    private void fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_fechaMouseClicked

    private void box_horaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box_horaMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_box_horaMouseClicked

    private void box_doctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box_doctorMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_box_doctorMouseClicked

    private void txt_area_motivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_area_motivoMouseClicked
        mensaje.setText("");
    }//GEN-LAST:event_txt_area_motivoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_boton;
    private javax.swing.JPanel Panel_boton;
    private javax.swing.JComboBox<String> box_doctor;
    private javax.swing.JComboBox<String> box_hora;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_doctor;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_hora;
    private javax.swing.JLabel label_motivo;
    private javax.swing.JLabel mensaje;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextArea txt_area_motivo;
    // End of variables declaration//GEN-END:variables
}
