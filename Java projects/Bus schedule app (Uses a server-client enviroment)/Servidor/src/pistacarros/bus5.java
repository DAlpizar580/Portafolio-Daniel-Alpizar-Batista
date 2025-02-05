package pistacarros;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class bus5 extends Thread {

 
    
    private String numbus = "bus 5";

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
            
        } catch (InterruptedException ex) {
            Logger.getLogger(bus3.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Este while funciona para que el bus se mueva hasta que sea el tiempo
        while (Cronometro_frame.isActivo()) {
         //Valida la posicion
         if (i == 1) {
             //mueve el bus a donde debe ir
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(52,170);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 2) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(70,155);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 3) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(85,164);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(102,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 5) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(124,163);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 6) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(144,169);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(159,182);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 8) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(168,194);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 9) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(182,211);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(196,220);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 11) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(209,224);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 12) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(226,232);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(240,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 14) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(256,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 15) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(280,258);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 17) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(317,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 18) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(335,245);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(348,243);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 20) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(362,242);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 21) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(377,237);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(391,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 23) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(405,249);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 24) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(421,254);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(436,263);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 26) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(445,277);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 27) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(460,287);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 29) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(467,324);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 30) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(475,349);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(492,356);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 32) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(475,349);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 33) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(467,324);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(464,305);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 35) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(460,287);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 36) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(445,277);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(436,263);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 38) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(421,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 39) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(405,249);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(391,241);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 41) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(377,237);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 42) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(362,242);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(348,243);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 44) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(335,245);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 45) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(317,249);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(299,254);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 47) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(280,258);
                try { Thread.sleep(1000);
                }catch(InterruptedException ex){
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 48) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(256,254);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(240,241);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 50) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(226,232);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 51) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(209,224);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(196,220);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 53) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(182,211);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 54) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(168,194);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(159,182);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 56) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(144,159);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 57) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(124,163);
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
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(102,163);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 59) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(85,164);
                try { Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(bus2.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            if (i == 60) {
                Interfaz.cinco.setIcon(new ImageIcon(Interfaz.img5));
                Interfaz.cinco.setLocation(70,155);
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


