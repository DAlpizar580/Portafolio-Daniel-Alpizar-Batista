package pistacarros;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class bus10 extends Thread {

  
    private String numbus = "bus 10";
    
    int i = 0;

    public void setI(int i) {
        this.i = i;
    }
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
            Thread.sleep(3750);
            Thread.sleep(3500);
            Thread.sleep(3250);
        } catch (InterruptedException ex) {
            Logger.getLogger(bus3.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Este while funciona para que el bus se mueva hasta que sea el tiempo
        while (Cronometro_frame.isActivo()) {
         //Valida la posicion
         if (i == 1) {
             //mueve el bus a donde debe ir
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(52,170);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 2) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(70,155);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 3) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(85,164);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(102,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 5) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(124,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 6) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(144,169);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(159,182);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 8) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(168,194);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 9) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(182,211);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(196,220);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 11) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(209,224);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 12) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(226,232);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(240,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 14) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(256,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 15) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(280,258);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 17) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(317,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 18) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(335,245);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(348,243);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 20) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(362,242);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 21) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(377,237);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(391,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 23) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(405,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 24) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(421,254);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(436,263);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 26) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(445,277);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 27) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(460,287);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 29) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(467,324);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 30) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(475,349);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(492,356);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 32) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(475,349);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 33) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(467,324);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 35) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(460,287);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 36) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(445,277);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(436,263);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 38) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(421,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 39) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(405,249);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(391,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 41) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(377,237);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 42) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(362,242);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(348,243);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 44) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(335,245);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 45) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(317,249);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 47) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(280,258);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 48) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(256,254);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(240,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 50) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(226,232);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 51) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(209,224);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(196,220);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 53) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(182,211);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 54) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(168,194);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(159,182);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 56) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(144,159);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 57) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(124,163);
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
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(102,163);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 59) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(85,164);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 60) {
                Interfaz.diez.setIcon(new ImageIcon(Interfaz.img10));
                Interfaz.diez.setLocation(70,155);
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


