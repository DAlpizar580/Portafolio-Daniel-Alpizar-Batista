/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import Paginas_menu.enviar_correo_a_paciente;
import Paginas_menu.cita_doctores;
import Paginas_menu.ver_datos_doctores;
import Paginas_menu.ver_info_de_pacientes;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 * Clase menu_doctores para mostrar el menú principal para doctores
 * Esta clase contiene métodos para configurar la interfaz de usuario
 * y mostrar diferentes paneles correspondientes a diferentes acciones
 * que los doctores pueden realizar en el sistema.
 * Extiende JFrame para crear la interfaz gráfica.
 */
public class menu_doctores extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    private String name;

    /**
     * Constructor de la clase menu_doctores.
     * @param NAME El nombre del doctor para mostrar en el menú.
     */
    public menu_doctores(String NAME) {
        initComponents();
        this.setLocationRelativeTo(this);
        this.name = NAME;
        
        // Métodos para configurar las imágenes de los íconos en la interfaz
        SetImageLabel(Logo, "src\\Imagenes\\Imagen menu principal_Logo.png");
        SetImageLabel(img_minimizar, "src\\Imagenes\\-.png");
        SetImageLabel(img_cerrar, "src\\Imagenes\\x.png");
        SetImageLabel(Profile, "src\\Imagenes\\Profile.png");
        SetImageLabel(Citas_logo, "src\\Imagenes\\logo_citas.png");
        SetImageLabel(Editar_Info_Logo, "src\\Imagenes\\ver_info.png");
        SetImageLabel(Consulta_Logo, "src\\Imagenes\\mail_icon.png");
        SetImageLabel(Logout, "src\\Imagenes\\Logout.png");  
    }
    
    /**
     * Método para configurar las propiedades iniciales del JFrame.
     */
    public void initialize()
    {
        setTitle("Menu Doctores");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    /**
     * Método para mostrar un panel en el área de contenido principal.
     * @param frame El panel a mostrar.
     */
    public void mostrar_panel(Component frame)
    {
        frame.setSize(620, 530);
        frame.setLocation(0,0); 
        Body.removeAll();
        Body.add(frame);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Panel_menu = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Label_titulo = new javax.swing.JLabel();
        Panel_Menu = new javax.swing.JPanel();
        Panel_citas = new javax.swing.JPanel();
        Citas_logo = new javax.swing.JLabel();
        Label_sacar_citas = new javax.swing.JLabel();
        Panel_Editar_Info = new javax.swing.JPanel();
        Editar_Info_Logo = new javax.swing.JLabel();
        Editar_Info_Label = new javax.swing.JLabel();
        Panel_Consulta = new javax.swing.JPanel();
        Consulta_Logo = new javax.swing.JLabel();
        Consulta_Label = new javax.swing.JLabel();
        Hospital_name = new javax.swing.JLabel();
        Manu_Separation = new javax.swing.JPanel();
        Profile_Panel = new javax.swing.JPanel();
        Profile = new javax.swing.JLabel();
        Logout_Panel = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        Panel_arriba = new javax.swing.JPanel();
        img_minimizar = new javax.swing.JLabel();
        img_cerrar = new javax.swing.JLabel();
        Header_panel = new javax.swing.JPanel();
        Body = new javax.swing.JPanel();

        jLabel1.setText("Menu doctores");

        jLabel2.setText("agendar citas");

        jLabel3.setText("ver info pacientes");

        jLabel4.setText("enviar correo a pacientes");

        jButton1.setText("click");

        jButton2.setText("click");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("click");

        jButton4.setText("volver");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(84, 84, 84))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addGap(78, 78, 78)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ver informacion pacientes");

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Menu doctores");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_menu.setBackground(new java.awt.Color(64, 157, 204));
        Panel_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagen menu principal_Logo.png"))); // NOI18N
        Panel_menu.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 77, 51, 48));

        Label_titulo.setFont(new java.awt.Font("Roboto Black", 0, 22)); // NOI18N
        Label_titulo.setForeground(new java.awt.Color(255, 255, 255));
        Label_titulo.setText("Menu Doctores");
        Panel_menu.add(Label_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 77, -1, 48));

        Panel_Menu.setBackground(new java.awt.Color(64, 153, 167));

        Panel_citas.setBackground(new java.awt.Color(64, 153, 167));
        Panel_citas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_citasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_citasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_citasMouseExited(evt);
            }
        });

        Citas_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo_citas.png"))); // NOI18N

        Label_sacar_citas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        Label_sacar_citas.setForeground(new java.awt.Color(255, 255, 255));
        Label_sacar_citas.setText("Sacar Cita a Paciente");

        javax.swing.GroupLayout Panel_citasLayout = new javax.swing.GroupLayout(Panel_citas);
        Panel_citas.setLayout(Panel_citasLayout);
        Panel_citasLayout.setHorizontalGroup(
            Panel_citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_citasLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Citas_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Label_sacar_citas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Panel_citasLayout.setVerticalGroup(
            Panel_citasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_sacar_citas, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addComponent(Citas_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        Panel_Editar_Info.setBackground(new java.awt.Color(64, 153, 167));
        Panel_Editar_Info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Editar_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_Editar_InfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_Editar_InfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_Editar_InfoMouseExited(evt);
            }
        });

        Editar_Info_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver_info.png"))); // NOI18N

        Editar_Info_Label.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        Editar_Info_Label.setForeground(new java.awt.Color(255, 255, 255));
        Editar_Info_Label.setText("Ver info de Pacientes");

        javax.swing.GroupLayout Panel_Editar_InfoLayout = new javax.swing.GroupLayout(Panel_Editar_Info);
        Panel_Editar_Info.setLayout(Panel_Editar_InfoLayout);
        Panel_Editar_InfoLayout.setHorizontalGroup(
            Panel_Editar_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_Editar_InfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Editar_Info_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Editar_Info_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_Editar_InfoLayout.setVerticalGroup(
            Panel_Editar_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Editar_Info_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
            .addComponent(Editar_Info_Logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        Panel_Consulta.setBackground(new java.awt.Color(64, 153, 167));
        Panel_Consulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Panel_Consulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Panel_ConsultaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_ConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_ConsultaMouseExited(evt);
            }
        });

        Consulta_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mail_icon.png"))); // NOI18N

        Consulta_Label.setFont(new java.awt.Font("Roboto Medium", 0, 17)); // NOI18N
        Consulta_Label.setForeground(new java.awt.Color(255, 255, 255));
        Consulta_Label.setText("Enviar Correo a Paciente");

        javax.swing.GroupLayout Panel_ConsultaLayout = new javax.swing.GroupLayout(Panel_Consulta);
        Panel_Consulta.setLayout(Panel_ConsultaLayout);
        Panel_ConsultaLayout.setHorizontalGroup(
            Panel_ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ConsultaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Consulta_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Consulta_Label)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_ConsultaLayout.setVerticalGroup(
            Panel_ConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Consulta_Label, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addComponent(Consulta_Logo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Panel_MenuLayout = new javax.swing.GroupLayout(Panel_Menu);
        Panel_Menu.setLayout(Panel_MenuLayout);
        Panel_MenuLayout.setHorizontalGroup(
            Panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Editar_Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_citas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_Consulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Panel_MenuLayout.setVerticalGroup(
            Panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MenuLayout.createSequentialGroup()
                .addComponent(Panel_citas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Editar_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Consulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Panel_menu.add(Panel_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 158, 282, -1));

        Hospital_name.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        Hospital_name.setForeground(new java.awt.Color(255, 255, 255));
        Hospital_name.setText("HOSPITAL ULACIT");
        Panel_menu.add(Hospital_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        Manu_Separation.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Manu_SeparationLayout = new javax.swing.GroupLayout(Manu_Separation);
        Manu_Separation.setLayout(Manu_SeparationLayout);
        Manu_SeparationLayout.setHorizontalGroup(
            Manu_SeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Manu_SeparationLayout.setVerticalGroup(
            Manu_SeparationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        Panel_menu.add(Manu_Separation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 282, -1));

        Profile_Panel.setBackground(new java.awt.Color(64, 157, 204));

        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profile.png"))); // NOI18N
        Profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfileMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Profile_PanelLayout = new javax.swing.GroupLayout(Profile_Panel);
        Profile_Panel.setLayout(Profile_PanelLayout);
        Profile_PanelLayout.setHorizontalGroup(
            Profile_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
        );
        Profile_PanelLayout.setVerticalGroup(
            Profile_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
        );

        Panel_menu.add(Profile_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 51, 50));

        Logout_Panel.setBackground(new java.awt.Color(64, 157, 204));

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logout.png"))); // NOI18N
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Logout_PanelLayout = new javax.swing.GroupLayout(Logout_Panel);
        Logout_Panel.setLayout(Logout_PanelLayout);
        Logout_PanelLayout.setHorizontalGroup(
            Logout_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Logout_PanelLayout.createSequentialGroup()
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );
        Logout_PanelLayout.setVerticalGroup(
            Logout_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
        );

        Panel_menu.add(Logout_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 50, 50));

        getContentPane().add(Panel_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        Panel_arriba.setBackground(new java.awt.Color(64, 130, 142));

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

        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png"))); // NOI18N
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

        javax.swing.GroupLayout Panel_arribaLayout = new javax.swing.GroupLayout(Panel_arriba);
        Panel_arriba.setLayout(Panel_arribaLayout);
        Panel_arribaLayout.setHorizontalGroup(
            Panel_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_arribaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(img_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        Panel_arribaLayout.setVerticalGroup(
            Panel_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_arribaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_arribaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(img_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Panel_arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 620, 40));

        Header_panel.setBackground(new java.awt.Color(64, 157, 204));
        Header_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                Header_panelMouseDragged(evt);
            }
        });
        Header_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Header_panelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout Header_panelLayout = new javax.swing.GroupLayout(Header_panel);
        Header_panel.setLayout(Header_panelLayout);
        Header_panelLayout.setHorizontalGroup(
            Header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        Header_panelLayout.setVerticalGroup(
            Header_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(Header_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        Body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        getContentPane().add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 620, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


// Método para arrastrar la ventana al hacer clic y arrastrar el panel
    private void Header_panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Header_panelMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_Header_panelMouseDragged


// Método para obtener la posición del mouse al presionar el panel de encabezado
    private void Header_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Header_panelMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_Header_panelMousePressed


// Acción al hacer clic en el panel de citas
    private void Panel_citasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_citasMouseClicked
        mostrar_panel(new cita_doctores(name));
    }//GEN-LAST:event_Panel_citasMouseClicked


// Cambio de color del panel de citas al entrar al área del panel
    private void Panel_citasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_citasMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_citas.setBackground(color1);
    }//GEN-LAST:event_Panel_citasMouseEntered


// Restablecer color del panel de citas al salir del área del panel
    private void Panel_citasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_citasMouseExited
        Color color2 = new Color (64,153,167);
        Panel_citas.setBackground(color2);
    }//GEN-LAST:event_Panel_citasMouseExited


// Acción al hacer clic en el panel de editar información
    private void Panel_Editar_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Editar_InfoMouseClicked
        mostrar_panel(new ver_info_de_pacientes());
    }//GEN-LAST:event_Panel_Editar_InfoMouseClicked


// Cambio de color del panel de editar información al entrar al área del panel
    private void Panel_Editar_InfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Editar_InfoMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_Editar_Info.setBackground(color1);
    }//GEN-LAST:event_Panel_Editar_InfoMouseEntered


// Restablecer color del panel de editar información al salir del área del panel
    private void Panel_Editar_InfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Editar_InfoMouseExited
        Color color2 = new Color (64,153,167);
        Panel_Editar_Info.setBackground(color2);
    }//GEN-LAST:event_Panel_Editar_InfoMouseExited


// Acción al hacer clic en el panel de consulta
    private void Panel_ConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultaMouseClicked
        mostrar_panel(new enviar_correo_a_paciente(name));
    }//GEN-LAST:event_Panel_ConsultaMouseClicked


// Cambio de color del panel de consulta al entrar al área del panel
    private void Panel_ConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultaMouseEntered
        Color color1 = new Color (64,130,142);
        Panel_Consulta.setBackground(color1);
    }//GEN-LAST:event_Panel_ConsultaMouseEntered


// Restablecer color del panel de consulta al salir del área del panel
    private void Panel_ConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_ConsultaMouseExited
        Color color2 = new Color (64,153,167);
        Panel_Consulta.setBackground(color2);
    }//GEN-LAST:event_Panel_ConsultaMouseExited


// Acción al hacer clic en el ícono de perfil
    private void ProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseClicked
        mostrar_panel(new ver_datos_doctores(this.name));
    }//GEN-LAST:event_ProfileMouseClicked


// Cambio de imagen del ícono de perfil al entrar al área del ícono
    private void ProfileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseEntered
        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profile_hover.png")));
        SetImageLabel(Profile, "src\\Imagenes\\Profile_hover.png");
    }//GEN-LAST:event_ProfileMouseEntered


// Restablecer imagen del ícono de perfil al salir del área del ícono
    private void ProfileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileMouseExited
        Profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profile.png")));
        SetImageLabel(Profile, "src\\Imagenes\\Profile.png");
    }//GEN-LAST:event_ProfileMouseExited


// Acción al hacer clic en el ícono de cerrar sesión
    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        menu_principal menu_principal = new menu_principal();
        menu_principal.initialize();
        dispose();
    }//GEN-LAST:event_LogoutMouseClicked


// Cambio de imagen del ícono de cerrar sesión al entrar al área del ícono
    private void LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseEntered
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logout_hover.png")));
        SetImageLabel(Logout, "src\\Imagenes\\Logout_hover.png");
    }//GEN-LAST:event_LogoutMouseEntered


// Restablecer imagen del ícono de cerrar sesión al salir del área del ícono
    private void LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseExited
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logout.png")));
        SetImageLabel(Logout, "src\\Imagenes\\Logout.png");
    }//GEN-LAST:event_LogoutMouseExited

    
// Acción al hacer clic en el ícono de minimizar
    private void img_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseClicked
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_img_minimizarMouseClicked

    
// Cambio de imagen del ícono de minimizar al entrar al área del ícono    
    private void img_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseEntered
        img_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/-_hover.png")));
        SetImageLabel(img_minimizar, "src\\Imagenes\\-_hover.png");
    }//GEN-LAST:event_img_minimizarMouseEntered

    
// Restablecer imagen del ícono de minimizar al salir del área del ícono    
    private void img_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_minimizarMouseExited
        img_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/-.png")));
        SetImageLabel(img_minimizar, "src\\Imagenes\\-.png");
    }//GEN-LAST:event_img_minimizarMouseExited

    
// Acción al hacer clic en el ícono de cerrar ventana    
    private void img_cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_img_cerrarMouseClicked

    
// Cambio de imagen del ícono de cerrar ventana al entrar al área del ícono
    private void img_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseEntered
        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x_hover.png")));
        SetImageLabel(img_cerrar, "src\\Imagenes\\x_hover.png");
    }//GEN-LAST:event_img_cerrarMouseEntered

    
// Restablecer imagen del ícono de cerrar ventana al salir del área del ícono
    private void img_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_cerrarMouseExited
        img_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/x.png")));
        SetImageLabel(img_cerrar, "src\\Imagenes\\x.png");
    }//GEN-LAST:event_img_cerrarMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* Si Nimbus (introducido en Java SE 6) no está disponible, se usa el aspecto visual predeterminado.
     * Para más detalles, consulta http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        // Si no se encuentra la clase de aspecto visual, se registra el error
        java.util.logging.Logger.getLogger(menu_doctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        // Si hay un problema al instanciar el aspecto visual, se registra el error
        java.util.logging.Logger.getLogger(menu_doctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        // Si hay acceso ilegal al aspecto visual, se registra el error
        java.util.logging.Logger.getLogger(menu_doctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        // Si el aspecto visual no es compatible, se registra el error
        java.util.logging.Logger.getLogger(menu_doctores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    // Se crea y muestra la ventana de menú de doctores
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Se instancia y muestra la ventana de menú de doctores
            new menu_doctores(null).setVisible(true);
        }
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JLabel Citas_logo;
    private javax.swing.JLabel Consulta_Label;
    private javax.swing.JLabel Consulta_Logo;
    private javax.swing.JLabel Editar_Info_Label;
    private javax.swing.JLabel Editar_Info_Logo;
    private javax.swing.JPanel Header_panel;
    private javax.swing.JLabel Hospital_name;
    private javax.swing.JLabel Label_sacar_citas;
    private javax.swing.JLabel Label_titulo;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel Logout_Panel;
    private javax.swing.JPanel Manu_Separation;
    private javax.swing.JPanel Panel_Consulta;
    private javax.swing.JPanel Panel_Editar_Info;
    private javax.swing.JPanel Panel_Menu;
    private javax.swing.JPanel Panel_arriba;
    private javax.swing.JPanel Panel_citas;
    private javax.swing.JPanel Panel_menu;
    private javax.swing.JLabel Profile;
    private javax.swing.JPanel Profile_Panel;
    private javax.swing.JLabel img_cerrar;
    private javax.swing.JLabel img_minimizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    
        private void SetImageLabel(JLabel labelName, String root) {
    // Se crea un objeto ImageIcon a partir de la ruta de la imagen proporcionada
    ImageIcon image = new ImageIcon(root);
    
    // Se crea un objeto Icon a partir de la imagen, escalándola al tamaño del JLabel
    Icon icon = new ImageIcon(image.getImage().getScaledInstance(
            labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
    
    // Se establece el ícono al JLabel proporcionado
    labelName.setIcon(icon);
    
    // Se repinta el componente para reflejar los cambios
    this.repaint();
}
        
}
