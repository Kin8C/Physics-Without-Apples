package juegogui;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import static juegogui.Inicio.manejo;

//import java.io.File;
//
//import javax.sound.sampled.AudioFileFormat;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.swing.JFrame;
/**
 *
 * @author SLFR
 */
public class JuegoGUI extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //------ Puntajes     
        manejo.leer();
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        ventana.setResizable(false);
        Sonido.reproducir();
    }

    public static class Sonido extends Player {              
        static FileInputStream fis;
        static Player player1;
        public Sonido(InputStream in) throws JavaLayerException {
            super(in);
        }  
        public static void reproducir(){            
            try {
                fis = new FileInputStream("SpookCapers.mp3");// Modificar la ruta
                BufferedInputStream bis = new BufferedInputStream(fis);

                player1 = new Player(bis);

                try {

                    {
                        player1.play();
                    }

                } catch (Exception e) {

                }

            } catch (JavaLayerException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        public static void detener(){    
            player1.close();
        }
    }

}
