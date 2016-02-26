package juegogui;
import java.lang.Object;
import javax.swing.JOptionPane;

/**
 *
 * @author Elkin
 */
public class SoporteJuego {

    public SoporteJuego() {
    }

    public void revivi() {
        GUI.g = 98;
        GUI.v = 130;
        GUI.a = 20;
        GUI.t = 0;
        GUI gui = new GUI();
        Drag draganddrop = new Drag();
        //ConectSerialPortBidericcional.manejoDrag();
        System.out.println("Revivi");
    }
    
    public void regrese(){
        GUI.g = 98;
        GUI.v = 130;
        GUI.a = 20;
        GUI.t = 0;
        Drag draganddrop = new Drag();
    }

}
