package pistacarros;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class bus7 extends Thread {


    private String numbus = "bus 7";

    public void setI(int i) {
        this.i = i;
    }
    
    int i = 0;
    @Override
    public void run() {
        i = 1;
        try { //sleep para que los buses salgan en diferente momento
            Thread.sleep(3500);
            Thread.sleep(3250);
            Thread.sleep(3500);
            Thread.sleep(3750);
            Thread.sleep(3500);
            Thread.sleep(3250);
            Thread.sleep(3500);
        } catch (InterruptedException ex) {
            Logger.getLogger(bus3.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Este while funciona para que el bus se mueva hasta que sea el tiempo
        while (Cronometro_frame.isActivo()) {
         //Valida la posicion
          if (i == 1) {
              //mueve el bus a donde debe ir
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(52,170);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 2) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(70,155);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 3) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(85,164);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                //manda los datos al servidor para que envie el mensaje
                Servidor.setBus(numbus);
                Servidor.setParada("parada 1");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1); //indica al servidor que debe enviar un mensaje
                i++;
            }
            if (i == 4) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(102,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 5) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(124,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 6) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(144,169);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 2");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 7) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(159,182);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 8) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(168,194);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 9) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(182,211);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 3");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 10) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(196,220);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 11) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(209,224);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 12) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(226,232);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 4");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 13) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(240,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 14) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(256,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 15) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(280,258);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 5");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 16) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 17) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(317,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 18) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(335,245);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 6");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 19) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(348,243);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 20) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(362,242);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 21) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(377,237);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 7");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 22) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(391,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 23) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(405,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 24) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(421,254);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 8");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 25) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(436,263);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 26) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(445,277);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 27) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(460,287);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 9");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 28) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 29) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(467,324);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 30) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(475,349);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 10");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 31) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(492,356);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 32) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(475,349);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 33) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(467,324);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 11");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 34) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 35) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(460,287);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 36) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(445,277);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 12");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 37) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(436,263);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 38) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(421,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 39) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(405,249);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 13");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 40) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(391,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 41) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(377,237);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 42) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(362,242);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 14");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 43) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(348,243);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 44) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(335,245);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 45) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(317,249);
                try { Thread.sleep(3000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 15");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 46) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 47) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(280,258);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 48) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(256,254);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 16");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 49) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(240,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 50) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(226,232);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 51) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(209,224);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 17");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 52) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(196,220);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 53) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(182,211);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 54) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(168,194);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 18");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 55) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(159,182);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 56) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(144,159);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 57) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(124,163);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 19");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                i++;
            }
            if (i == 58) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(102,163);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 59) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(85,164);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 60) {
                Interfaz.siete.setIcon(new ImageIcon(Interfaz.img7));
                Interfaz.siete.setLocation(70,155);
                try { Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                Servidor.setBus(numbus);
                Servidor.setParada("parada 20");
                Servidor.setHora(Cronometro_frame.getHoras() + ":" + Cronometro_frame.getMinutos());
                Servidor.setVar(Servidor.getVar() + 1);
                
                i = 1;
            }}
        }
    }


