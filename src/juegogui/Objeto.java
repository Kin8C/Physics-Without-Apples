package juegogui;


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sebastián
 */
public class Objeto {

    private int x, y, ancho, alto;

    public Objeto(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = x + ancho;
        this.alto = y + alto;
    }

    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}
    
    public void cargarImagenes(BufferedImage imagen, String nombre) {
        try {
            //importo las imagenes que van a ser usadas
            imagen = ImageIO.read(getClass().getClassLoader().getResource(nombre));   //locacion de la imagen
        } catch (Exception e) {
            //maneja excepciones como por ejemplo que no encuentre la imagen a cargar
            System.out.println("No se encontro la imagen");
        }
    }
}
