package juegogui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;

public class area_de_dibujo extends JPanel {

    private double Pos_x, Pos_y;
    private BufferedImage apple, diana;

    public area_de_dibujo() {
        cargarImagenes();
    }

    public double getPos_x() {
        return Pos_x;
    }

    public void setPos_x(double Pos_x) {
        this.Pos_x = Pos_x;
    }

    public double getPos_y() {
        return Pos_y;
    }

    public void setPos_y(double Pos_y) {
        this.Pos_y = Pos_y;
    }

    public void cargarImagenes() {
        try {
            //importo las imagenes que van a ser usadas
            apple = ImageIO.read(getClass().getClassLoader().getResource("AppleCore.png"));   //locacion de la imagen
            diana = ImageIO.read(getClass().getClassLoader().getResource("diana.png"));   //locacion de la imagen
        } catch (Exception e) {
            //maneja excepciones como por ejemplo que no encuentre la imagen a cargar
            System.out.println("No se encontro la imagen");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon dos=new ImageIcon(this.getClass().getResource("/imagenes/fondoJuego.jpg"));//Agregar Imagen Fondo
        g.drawImage(dos.getImage(),0,-70,800,600, null);
        g.drawImage(diana, 508, 445, null);
        g.drawImage(apple, (int) Pos_x, (int) Pos_y, null);
//        g.drawString(gravedadLabel.getText(), 600, 30);
//        g.drawString(velocidad.getText(), 600, 50);
//        g.drawString(angulo.getText(), 600, 70);

    }

//    public static void textos() {
//        gravedadLabel.setText(Double.toString(GUI.g));
//        velocidad.setText(Double.toString(GUI.v));
//        angulo.setText(Double.toString(GUI.a));
//    }
    public boolean Collision() {

        int ax1 = 508; //Posicion en x de la diana;
        int ay1 = 470; //Posicion en y de la diana;
        int ax2 = ax1 + 30; //ax1 + ancho de la diana;
        int ay2 = ay1 + 5; //ay1 + altura de la diana;
        int bx1 = (int) Pos_x; //Posicion en x de la manzana;
        int by1 = (int) Pos_y; //Posicion en y de la manzana;
        int bx2 = bx1 + 17; //bx1 + ancho de la manzana;
        int by2 = by1 + 20; //by1 + altura de la manzana;

        // ------- Colision Sheldon-----
        int coliseoXA = Drag.posicionColiseoX + 150;
        int coliseoYA = Drag.posicionColiseoY + 150;
        int ufoXA = Drag.posicionUFOX + 130;
        int ufoYA = Drag.posicionUFOY + 75;
        int pegasusXA = Drag.posicionPegasusX + 94;
        int pegasusYA = Drag.posicionPegasusY + 94;
        int stockXA = Drag.posicionStockX + 93;
        int stockYA = Drag.posicionStockY + 86;
        int torreXA = Drag.posicionTorreX + 76;
        int torreYA = Drag.posicionTorreY + 180;
//        System.out.println("POS X: " + Drag.posicionTorreX);
//        System.out.println("POS Y: " + Drag.posicionTorreY);
//        System.out.println("bx2 : " + bx2);
//        System.out.println("by2 : " + by2);

//        if ((by2 < Drag.posicionSheldonY) || (coliseoYA < by1) || (bx2 < Drag.posicionSheldonX) || (coliseoXA < bx1)) {
//            return false;} 
        
        // --- Colision Coliseo
        if ((((by2 > Drag.posicionColiseoY || by1 > Drag.posicionColiseoY)) && ((by2 < coliseoYA) || (by1 < coliseoYA))) && (bx2 > Drag.posicionColiseoX) && (bx2 < coliseoXA)) {
            System.out.println("Colissionaste con Coliseo--------------------------------------");
            return true;
        }
        // --- Colision UFO ufoXA = Drag.posicionUFOX;
        if ((((by2 > Drag.posicionUFOY || by1 > Drag.posicionUFOY)) && ((by2 < ufoYA) || (by1 < ufoYA))) && (bx2 > Drag.posicionUFOX) && (bx2 < ufoXA)) {
            System.out.println("Colissionaste con UFO--------------------------------------");
            return true;
        }
        // --- Colision Pegasus pegasusYA = Drag.posicionPegasusY
        if ((((by2 > Drag.posicionPegasusY || by1 > Drag.posicionPegasusY)) && ((by2 < pegasusYA) || (by1 < pegasusYA))) && (bx2 > Drag.posicionPegasusX) && (bx2 < pegasusXA)) {
            System.out.println("Colissionaste con Pegasus--------------------------------------");
            return true;
        }
        // --- Colision Stock stockXA = Drag.posicionStockX 
        if ((((by2 > Drag.posicionStockY || by1 > Drag.posicionStockY)) && ((by2 < stockYA) || (by1 < stockYA))) && (bx2 > Drag.posicionStockX) && (bx2 < stockXA)) {
            System.out.println("Colissionaste con Stock--------------------------------------");
            return true;
        }
        // --- Colision Torre torreYA = Drag.posicionTorreY
        if ((((by2 > Drag.posicionTorreY || by1 > Drag.posicionTorreY)) && ((by2 < torreYA) || (by1 < torreYA))) && (bx2 > Drag.posicionTorreX) && (bx2 < torreXA)) {
            System.out.println("Colissionaste con La Torre --------------------------------------");
            return true;
        } 
        //   x 168 ,  y 388
        //         else if (bx2 > Drag.posicionSheldonX) {
        //            System.out.println("Colisione con Sheldon");
        //            return true;
        //        } 
        //        else if (bx2 > Drag.posicionColiseoX) {
        //            System.out.println("Colisione con Coliseo");
        //            return true;
        //        } 
        // ------- Fin Colision Sheldon----
        else if (by2 < ay1 || ay2 < by1 || bx2 < ax1 || ax2 < bx1) {
            return false; //La colision es imposible;

        } else {
            return true;
        }
    }
    
    public boolean collisionSheldon(){
        int ax1 = 508; //Posicion en x de la diana;
        int ay1 = 470; //Posicion en y de la diana;
        int ax2 = ax1 + 30; //ax1 + ancho de la diana;
        int ay2 = ay1 + 5; //ay1 + altura de la diana;
        int bx1 = (int) Pos_x; //Posicion en x de la manzana;
        int by1 = (int) Pos_y; //Posicion en y de la manzana;
        int bx2 = bx1 + 17; //bx1 + ancho de la manzana;
        int by2 = by1 + 20; //by1 + altura de la manzana;        
        
        int sheldonXA = Drag.posicionSheldonX + 34;
        int sheldonYA = Drag.posicionSheldonY + 116;
        
        // --- Colision Sheldon
        if ((((by2 > Drag.posicionSheldonY || by1 > Drag.posicionSheldonY)) && ((by2 < sheldonYA) || (by1 < sheldonYA))) && (bx2 > Drag.posicionSheldonX) && (bx2 < sheldonXA)) {
            System.out.println("Colissionaste con Sheldon--------------------------------------");
            ConectSerialPortBidericcional.puntaje += 200;
            return true;
        }
        
        return false;
    }    
}
