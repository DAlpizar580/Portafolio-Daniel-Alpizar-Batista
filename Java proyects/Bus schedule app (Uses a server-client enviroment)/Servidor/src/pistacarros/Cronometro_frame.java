package pistacarros;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Cronometro_frame extends javax.swing.JFrame {

    //Declaracion de variables que se utilizan en varias partes del programa
    private static Timer timer;
    private static int dias = 0;
    private static int horas = 4;
    private static int minutos = 55;
    private int milisegundos = 0;
    private static boolean activo = true;
    private static bus1 bus1 = new bus1();
    private static bus2 bus2 = new bus2();
    private static bus3 bus3 = new bus3();
    private static bus4 bus4 = new bus4();
    private static bus5 bus5 = new bus5();
    private static bus6 bus6 = new bus6();
    private static bus7 bus7 = new bus7();
    private static bus8 bus8 = new bus8();
    private static bus9 bus9 = new bus9();
    private static bus10 bus10 = new bus10();
    
    public Cronometro_frame() {
        initComponents();
        setLocationRelativeTo(null);
        //Se crea el cronometro
        timer = new Timer(10, (ActionEvent e) -> { Cronometro(); });
    }
    
    private void Cronometro() {
        //llama a los metodos que hacen que el cronometro funcione
        ActualizaTiempo(); 
        ActualizarCronometro();
    }
    
    public static void iniciarBuses() throws InterruptedException{
        //Inicia todos los buses si son las 5am
         if (horas == 5){
            bus1.start();
            bus2.start();
            bus3.start();
            bus4.start();
            bus5.start();
            bus6.start();
            bus7.start();
            bus8.start();
            bus9.start();
            bus10.start();
            Servidor.setIniciado(false);
         }
        }
    
    
    public static void terminarBuses() throws InterruptedException{
        //valida que no sea domingo
        if (dias == 6)
        {
            //termina todos los buses a las 7pm
            if (horas == 19)
            {

                Cronometro_frame.activo = false;
                bus1.setI(60);
                bus2.setI(60);
                bus3.setI(60);
                bus4.setI(60);
                bus5.setI(60);
                bus6.setI(60);
                bus7.setI(60);
                bus8.setI(60);
                bus9.setI(60);
                bus10.setI(60);
                //los mueve a la posicion inicial
                Interfaz.uno.setLocation(52,170);
                Interfaz.dos.setLocation(52,170);
                Interfaz.tres.setLocation(52,170);
                Interfaz.cuatro.setLocation(52,170);
                Interfaz.cinco.setLocation(52,170);
                Interfaz.seis.setLocation(52,170);
                Interfaz.siete.setLocation(52,170);
                Interfaz.ocho.setLocation(52,170);
                Interfaz.nueve.setLocation(52,170);
                Interfaz.diez.setLocation(52,170);
                Servidor.setIniciado(true);
            }
        }
        else
        {
            //termina todos los buses a las 12 am
            if (horas == 0)
            {

                Cronometro_frame.activo = false;
                bus1.setI(60);
                bus2.setI(60);
                bus3.setI(60);
                bus4.setI(60);
                bus5.setI(60);
                bus6.setI(60);
                bus7.setI(60);
                bus8.setI(60);
                bus9.setI(60);
                bus10.setI(60);
                //los mueve a la posicion inicial
                Interfaz.uno.setLocation(52,170);
                Interfaz.dos.setLocation(52,170);
                Interfaz.tres.setLocation(52,170);
                Interfaz.cuatro.setLocation(52,170);
                Interfaz.cinco.setLocation(52,170);
                Interfaz.seis.setLocation(52,170);
                Interfaz.siete.setLocation(52,170);
                Interfaz.ocho.setLocation(52,170);
                Interfaz.nueve.setLocation(52,170);
                Interfaz.diez.setLocation(52,170);
                Interfaz.uno.setLocation(52,170);
                Servidor.setIniciado(true);
            }
        }
    }
    
    private void ActualizarCronometro(){
        //Clase que actualiza el cronometro en la interfaz
        String cronometro = horas + ":" + minutos;
        lblCronometro.setText(cronometro);
        switch (dias)
        {
            case 0:
                lbldia.setText("Lunes");
                break;
            case 1:
                lbldia.setText("Martes");
                break;
            case 2:
                lbldia.setText("Miercoles");
                break;
            case 3:
                lbldia.setText("Jueves");
                break;
            case 4:
                lbldia.setText("Viernes");
                break;
            case 5:
                lbldia.setText("Sabado");
                break;
            case 6:
                lbldia.setText("Domingo");
                break;   
        }
        
    }
    
     private void ActualizaTiempo() {
         //Aqui se lleva el conteo que se utiliza para el funcionamiento del cronometro
         milisegundos++;

        if (milisegundos == 100) {
            milisegundos = 0;
            minutos++;
        }

        if (minutos == 60) {
            minutos = 0;
            horas++;
        }
        
        if (horas == 24) {
            horas = 0;
            minutos = 0;
            timer.stop();
            btnhora.setEnabled(false);
            dias++;
        } 
        if (dias == 7)
        {
            dias = 0;
        }
        
    }

    //-------------------------GETTERS Y SETTERS----------------------------------
    public static int getDias() {
        return dias;
    }

    public static void setDias(int dias) {
        Cronometro_frame.dias = dias;
    }

    public static int getHoras() {
        return horas;
    }

    public static void setHoras(int horas) {
        Cronometro_frame.horas = horas;
    }

    public static int getMinutos() {
        return minutos;
    }

    public static void setMinutos(int minutos) {
        Cronometro_frame.minutos = minutos;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static boolean isActivo() {
        return activo;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbldia = new javax.swing.JLabel();
        btndia = new javax.swing.JButton();
        lblCronometro = new javax.swing.JLabel();
        btnhora = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbldia.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        lbldia.setText("Miercoles");

        btndia.setBackground(new java.awt.Color(153, 153, 153));
        btndia.setForeground(new java.awt.Color(255, 255, 255));
        btndia.setText("Adelantar dia");
        btndia.setBorder(null);
        btndia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndiaActionPerformed(evt);
            }
        });

        lblCronometro.setFont(new java.awt.Font("Roboto Black", 1, 36)); // NOI18N
        lblCronometro.setText("00:00");

        btnhora.setBackground(new java.awt.Color(153, 153, 153));
        btnhora.setForeground(new java.awt.Color(255, 255, 255));
        btnhora.setText("Adelantar hora");
        btnhora.setBorder(null);
        btnhora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(lbldia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCronometro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btndia, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnhora, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldia, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCronometro, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhora, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndiaActionPerformed
        Cronometro_frame.dias++;
    }//GEN-LAST:event_btndiaActionPerformed

    private void btnhoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhoraActionPerformed
        Cronometro_frame.horas++;
    }//GEN-LAST:event_btnhoraActionPerformed

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
            java.util.logging.Logger.getLogger(Cronometro_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cronometro_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cronometro_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cronometro_frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cronometro_frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndia;
    private javax.swing.JButton btnhora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCronometro;
    private javax.swing.JLabel lbldia;
    // End of variables declaration//GEN-END:variables

   
}
