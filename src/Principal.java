package juegogui;

import javax.swing.JOptionPane;
import static juegogui.Inicio.manejo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Elkin
 */
public class Principal {

    public static void main(String[] args) {
        boolean reiniciar = true;
        GUI gui = new GUI();
        ConectSerialPortBidericcional conexion = new ConectSerialPortBidericcional();
        conexion.ArduinoConnection();
        //------ Puntajes         
        while (reiniciar = true) {

            if (GUI.dibujo.Collision() == true || GUI.dibujo.getPos_y() > 501) {
                reiniciar = false;
                if (JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?") == JOptionPane.YES_OPTION) {
                    
                } else if (JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?") == JOptionPane.CANCEL_OPTION) {
                    System.exit(0);
                } else if (JOptionPane.showConfirmDialog(null, "Desea jugar de nuevo?") == JOptionPane.NO_OPTION) {
                    //Vuelve al menu ppal
                }
            }
        }
    }
}
