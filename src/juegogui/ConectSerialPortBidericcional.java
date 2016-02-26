package juegogui;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static juegogui.Drag.stock;

/**
 * @author Elkin
 */
public class ConectSerialPortBidericcional implements SerialPortEventListener {

    private OutputStream Output = null;
    private InputStream Input = null;
    SerialPort serialPort;
    private final String PORT_NAME = "COM3";
    private static final int TIME_OUT = 2000;
    private static final int DATA_RATE = 9600;
    public double valorX = 0;
    public double valorY = 0;
    public double gravedad = 0;
    public static boolean primeraVez = true;
    public static JLabel gravedadLabel;
    public static JLabel velocidad;
    public static JLabel angulo;
    static Drag draganddrop = new Drag();
    static int puntaje = 0;
    static int contadorNivel = 1;
    static boolean nuevoJugador = false;

    public void ArduinoConnection() {

        //condiciones iniciales        
        GUI.g = 98;
        //GUI.v = 230;
        //GUI.v = 78;
        GUI.v = 130;
        //GUI.a = 0;
        GUI.a = 20;        
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

            if (PORT_NAME.equals(currPortId.getName())) {
                portId = currPortId;
                break;
            }
        }

        if (portId == null) {

            System.exit(0);
            return;
        }

        try {

            serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

            serialPort.setSerialPortParams(DATA_RATE,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            Output = serialPort.getOutputStream(); //Se prepara a Output //para enviar datos
            Input = serialPort.getInputStream(); //Se prepara input para //recibir datos

            serialPort.addEventListener(this); //Se agrega un Event //Listener
            serialPort.notifyOnDataAvailable(true); //Se indica que se //notifique al usuario cuando sea que halla datos disponibles en //el puerto serie
        } catch (Exception e) {
            System.exit(0);
        }
    }

    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            //textos();
            System.out.println("Puntaje = " + puntaje);
            //System.out.println(Inicio.manejo.lista.getLast().getNombre());
            //System.out.println(Inicio.manejo.lista.getLast().getPuntaje());
            try {
                //int datos;
                //datos = RecibirDatos(); //Se invoca la función RecibirDatos()
                //EnviarDatos("3");//Esta función devolverá un valor entero en formato ASCII.
                //System.out.println((char)datos); //Se imprime en el mensaje
                //System.out.println(GUI.dibujo.getPos_y());                
                switch (Input.read()) {
                    case 'U':
                        //System.out.println("Arriba");
                        GUI.a += 5;
                        EnviarDatos("0");
//                        String valorU = Double.toString(GUI.a);
//                        EnviarDatos(valorU);
                        System.out.println("Valor Angulo = " + GUI.a);
                        break;
                    case 'D':
                        //System.out.println("Abajo");
                        if (GUI.a > 5) {
                            GUI.a -= 5;
                        }
                        System.out.println("Valor Angulo = " + GUI.a);
                        EnviarDatos("1");
//                        String valorD = Double.toString(GUI.a);
//                        EnviarDatos(valorD);
                        break;
                    case 'R':
                        //System.out.println("Derecha");                        
                        GUI.v += 10;
                        System.out.println("Valor Velocidad = " + GUI.v);
                        EnviarDatos("2");
//                        String valorR = Double.toString(GUI.a);
//                        EnviarDatos(valorR);
                        break;
                    case 'L':
                        //System.out.println("Izquierda");                        
                        if (GUI.v > 79) {
                            GUI.v -= 10;
                        }
                        System.out.println("Valor Velocidad = " + GUI.v);
                        EnviarDatos("3");
//                        String valorL = Double.toString(GUI.a);
//                        EnviarDatos(valorL);
                        break;
                    case 'H':
                        //System.out.println("Izquierda");
                        System.out.println("Gravedad = " + GUI.g);
                        if (GUI.g > 99) {
                            GUI.g -= 5;
                            System.out.println("Gravedad = " + GUI.g);
                        }
                        EnviarDatos("4");
//                        String valorH = Double.toString(GUI.a);
//                        EnviarDatos(valorH);
                        break;
                    case 'G':
                        //System.out.println("Izquierda");                        
                        GUI.g += 5;
                        System.out.println("Gravedad = " + GUI.g);
                        EnviarDatos("5");
//                        String valorG = Double.toString(GUI.a);
//                        EnviarDatos(valorG);
                        break;
                    case 'P':
                        //System.out.println("Push");
                        EnviarDatos("6");
                        GUI.tiempo.start();
                        break;
                    case '0':
                        System.out.println("Estable ");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    private int RecibirDatos() throws IOException {
        int Output = 0;
        Output = Input.read();
        return Output;
    }

    public static void tiroParaBolico() {
        if (GUI.dibujo.getPos_y() >= 0 && GUI.dibujo.getPos_y() < 470) {
            if (GUI.dibujo.getPos_x() < 670) {
                double v_y = GUI.v * Math.sin(Math.toRadians(GUI.a));
                double v_x = GUI.v * Math.cos(Math.toRadians(GUI.a));
                GUI.t += 0.1;
                GUI.x = v_x * GUI.t;
                GUI.y = (v_y * GUI.t) + ((-0.5 * GUI.g) * Math.pow(GUI.t, 2));
                GUI.dibujo.setPos_x(GUI.x);
                GUI.dibujo.setPos_y(400 - GUI.y);
                GUI.dibujo.repaint();
                //System.out.println("x = " + (int) GUI.dibujo.getPos_x() + " , " + "y = " + (int) GUI.dibujo.getPos_y());
                vida();
                if (GUI.dibujo.Collision() == true) {
                    //System.out.println("Venga le digo");
                } else {
                    //System.out.println("Venga no le digo");
                }
            }
        }
    }

    public static void vida() {

        Inicio.objeto.setPuntaje(puntaje);
        if (contadorNivel < 5) {
            // -------------------------------- Avanzas de Nivel ----------------
            if (GUI.dibujo.collisionSheldon() != false) {
                Drag.posicionColiseoX = 0;
                Drag.posicionColiseoY = 0;
                Drag.posicionSheldonX = 0;
                Drag.posicionSheldonY = 0;
                Drag.posicionUFOX = 0;
                Drag.posicionUFOY = 0;
                Drag.posicionPegasusX = 0;
                Drag.posicionPegasusY = 0;
                Drag.posicionStockX = 0;
                Drag.posicionStockY = 0;
                Drag.posicionTorreX = 0;
                Drag.posicionTorreY = 0;
                int continuar2;
                Inicio.objeto.setPuntaje(puntaje);
                continuar2 = JOptionPane.showConfirmDialog(null, "Felicitaciones Avanzas de Nivel \n Tu Puntuación es: " + Inicio.manejo.lista.getLast().getPuntaje(), "Siguiente Nivel", JOptionPane.YES_NO_OPTION);
                if (continuar2 == JOptionPane.YES_OPTION) {
                    contadorNivel++;
                    GUI.ventana.dispose();
                    GUI.tiempo.stop();
                    SoporteJuego vida = new SoporteJuego();
                    vida.revivi();
                }
                if (continuar2 == JOptionPane.NO_OPTION) {
                    Inicio.objeto.setPuntaje(puntaje);
                    Inicio.manejo.escribir();
                    GUI.ventana.dispose();
                    Inicio obj = new Inicio();
                    obj.setVisible(true);
                    SoporteJuego vida = new SoporteJuego();
                    vida.regrese();
                    nuevoJugador = true;
                    contadorNivel = 1;
                    puntaje = 0;
                    GUI.tiempo.stop();
                    Jugar.jugando = false;                  
                }
            }
            ///-------------------- 
            if ((GUI.dibujo.Collision() != false || GUI.dibujo.getPos_y() > 450 || GUI.dibujo.getPos_x() > 650 )&& (Jugar.jugando  != false)) {
                Drag.posicionColiseoX = 0;
                Drag.posicionColiseoY = 0;
                Drag.posicionSheldonX = 0;
                Drag.posicionSheldonY = 0;
                Drag.posicionUFOX = 0;
                Drag.posicionUFOY = 0;
                Drag.posicionPegasusX = 0;
                Drag.posicionPegasusY = 0;
                Drag.posicionStockX = 0;
                Drag.posicionStockY = 0;
                Drag.posicionTorreX = 0;
                Drag.posicionTorreY = 0;
//            if ((GUI.dibujo.getPos_y() < Drag.posicionSheldonY) && (GUI.dibujo.getPos_x() > Drag.posicionSheldonX)){
//                System.out.println("Colisione con sheldon");
//            }}

                int continuar;
                Inicio.objeto.setPuntaje(puntaje);
                continuar = JOptionPane.showConfirmDialog(null, "Fallaste \n Desea jugar de nuevo?\n Tu Puntuación es : " + Inicio.manejo.lista.getLast().getPuntaje(), "Continuar", JOptionPane.YES_NO_OPTION);

                if (continuar == JOptionPane.YES_OPTION) {
                    GUI.ventana.dispose();
                    GUI.tiempo.stop();
                    SoporteJuego vida = new SoporteJuego();
                    vida.revivi();
                    //GUI.draganddrop = null;
                    //System.runFinalization();
                } else if (continuar == JOptionPane.NO_OPTION) {
                    Inicio.objeto.setPuntaje(puntaje);
                    Inicio.manejo.escribir();
                    Inicio obj = new Inicio();
                    obj.setVisible(true);
                    SoporteJuego vida = new SoporteJuego();
                    vida.regrese();
                    nuevoJugador = true;
                    puntaje = 0;
                    GUI.ventana.dispose();
                    GUI.tiempo.stop();
                    contadorNivel = 1;
                    //Vuelve al menu ppal
                }
            }

        } else {
            int continuar;
            Inicio.objeto.setPuntaje(puntaje);
            continuar = JOptionPane.showConfirmDialog(null, "FELICITACIONES Has Completado el Juego\n Tu Puntuación es: " + Inicio.manejo.lista.getLast().getPuntaje(), "Deseas Continuar", JOptionPane.YES_NO_OPTION);
            if (continuar == JOptionPane.YES_OPTION) {
                Inicio.manejo.escribir();
                nuevoJugador = true;
                GUI.tiempo.stop();
                Ranking obj = new Ranking();
                obj.setVisible(true);
                GUI.ventana.dispose();
                contadorNivel = 1;
                puntaje = 0;

                //GUI.draganddrop = null;
                //System.runFinalization();            
            } else if (continuar == JOptionPane.NO_OPTION) {
                Inicio.objeto.setPuntaje(puntaje);
                Inicio.manejo.escribir();
                GUI.tiempo.stop();
                GUI.ventana.dispose();
                puntaje = 0;
                contadorNivel = 1;
                GUI.tiempo.stop();
                Ranking obj = new Ranking();
                obj.setVisible(true);

                //Vuelve al menu ppal
            }
        }

    }

    private void EnviarDatos(String datos) throws IOException {
        Output.write(datos.getBytes());
    }
}
