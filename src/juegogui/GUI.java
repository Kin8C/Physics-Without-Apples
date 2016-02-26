package juegogui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @authors Sebastián Vasco Elkin Beltran Sandra Fong Juan Sebastian Quintero
 */
public class GUI extends JFrame implements ActionListener {

    public static double x, y, t, a, v, g;
    public static area_de_dibujo dibujo;
    public static Timer tiempo, rotacion;
    public double angulo_r;
    public static JFrame ventana;

    public GUI() {
        tiempo = new Timer(50, this);
        //JFrame
        ventana = new JFrame("Physiscs Without Apples");
        //JPanel donde iran los botones
        JPanel area_botones = new JPanel();
        //JPanel donde se graficara
        dibujo = new area_de_dibujo();
        dibujo.setBackground(Color.GRAY);            
        //propiedades de la ventana
        //dibujo.setSize(800, 200);
        //dibujo.setBackground(Color.red);        
        ventana.setVisible(true);
        ventana.setSize(new Dimension(800, 600));
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        //adicion de los botones, labels y JTextFields al panel y de los paneles a la ventana
        area_botones.setLayout(new GridLayout(8, 1));
        ventana.add(area_botones, BorderLayout.WEST);
        //ESTABLESCO COORDENADAS INICIALES MANZANA
        dibujo.setPos_x(0);
        dibujo.setPos_y(400);
        ventana.add(dibujo, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConectSerialPortBidericcional.tiroParaBolico();
    }    
}
