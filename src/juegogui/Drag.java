/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegogui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Elkin
 */
public class Drag extends JPanel {

    //private final area_de_dibujo dibujo;
    private boolean creadoColiseo = false;
    private boolean creadoTorre = false;
    private boolean creadoUFO = false;
    private boolean creadoPegasus = false;
    private boolean creadoStock = false;
    private boolean creadoSheldon = false;
    static int posicionColiseoX; // 150 x 150
    static int posicionColiseoY;
    static int posicionTorreX; // 76 x 221
    static int posicionTorreY;
    static int posicionUFOX;  // 130 x 75
    static int posicionUFOY;
    static int posicionPegasusX; //94 x 94
    static int posicionPegasusY;
    static int posicionStockX; // 93 x 86
    static int posicionStockY;
    static int posicionSheldonX; // 34 x 116
    static int posicionSheldonY;
    public int valorx;
    public int valory;
    int contadorObjeto = 0;
    static JButton coliseo, torre, ufo, pegasus, stock, sheldon;

    public Drag() {      
        //JFrame ventana = new JFrame("Obstaculos");
        final JPanel areaBotones = new JPanel();
        //dibujo = new area_de_dibujo();
        //  dibujo.setBackground(Color.WHITE);
        ImageIcon c = new ImageIcon("src/imagenes/c.png");
        ImageIcon t = new ImageIcon("src/imagenes/t.png");
        ImageIcon u = new ImageIcon("src/imagenes/u.png");
        ImageIcon p = new ImageIcon("src/imagenes/p.png");
        ImageIcon s = new ImageIcon("src/imagenes/s.png");
        ImageIcon sc = new ImageIcon("src/imagenes/sc.png");
        coliseo = new JButton(c);
        coliseo.setContentAreaFilled(false);
        coliseo.setBorder(null);
         
        //coliseo.setEnabled(false);
        coliseo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                coliseo.setEnabled(false);
                final ImageIcon botonColiseo = new ImageIcon("src/imagenes/botonColiseo.png");
                final JButton DragColiseo = new JButton(botonColiseo);
                creadoColiseo = true;
                contadorObjeto++;
                System.out.println(contadorObjeto);
                DragColiseo.setSize(botonColiseo.getIconWidth(), botonColiseo.getIconHeight());
                DragColiseo.setContentAreaFilled(false);
                DragColiseo.setBorder(null);
                GUI.dibujo.add(DragColiseo);
                DragColiseo.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent m) {
                        DragColiseo.setBounds(m.getX(), m.getY(), botonColiseo.getIconWidth(), botonColiseo.getIconHeight());
                        GUI.dibujo.repaint();

                    }

                    @Override
                    public void mouseDragged(MouseEvent m) {

                        if (creadoColiseo != false) {
                            System.out.println("Estoy vivito");
                            DragColiseo.setBounds(m.getX(), m.getY(), botonColiseo.getIconWidth(), botonColiseo.getIconHeight());
                            creadoColiseo = false;
                        }
                        valorx = (m.getX() / 2) + valorx;
                        valory = (m.getY() / 2) + valory;
                        posicionColiseoX = valorx;
                        posicionColiseoY = valory;
                        System.out.println(valorx + " , " + valory);
                        DragColiseo.setLocation(valorx, valory);
                        GUI.dibujo.repaint();

                    }

                });

            }

        });

        ufo = new JButton(u);
        ufo.setContentAreaFilled(false);
        ufo.setBorder(null);
        
        //ufo.setEnabled(false);
        ufo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ufo.setEnabled(false);
                final ImageIcon botonUfo = new ImageIcon("src/imagenes/botonUfo.png");
                final JButton DragUfo = new JButton(botonUfo);
                creadoUFO = true;
                contadorObjeto++;
                System.out.println(contadorObjeto);
                DragUfo.setSize(botonUfo.getIconWidth(), botonUfo.getIconHeight());
                DragUfo.setContentAreaFilled(false);
                DragUfo.setBorder(null);
                GUI.dibujo.add(DragUfo);
                DragUfo.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent m) {
                        DragUfo.setBounds(m.getX(), m.getY(), botonUfo.getIconWidth(), botonUfo.getIconHeight());
                        GUI.dibujo.repaint();

                    }

                    @Override
                    public void mouseDragged(MouseEvent m) {

                        if (creadoUFO != false) {
                            System.out.println("Estoy vivito");
                            DragUfo.setBounds(m.getX(), m.getY(), botonUfo.getIconWidth(), botonUfo.getIconHeight());
                            creadoUFO = false;
                        }
                        valorx = (m.getX() / 2) + valorx;
                        valory = (m.getY() / 2) + valory;
                        posicionUFOX = valorx;
                        posicionUFOY = valory;
                        System.out.println(valorx + " , " + valory);
                        DragUfo.setLocation(valorx, valory);
                        GUI.dibujo.repaint();

                    }

                });

            }
        });

        pegasus = new JButton(p);
        pegasus.setContentAreaFilled(false);
        pegasus.setBorder(null);
        //pegasus.setEnabled(false);
        pegasus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                pegasus.setEnabled(false);
                ConectSerialPortBidericcional.puntaje += 10;
                final ImageIcon botonPegasus = new ImageIcon("src/imagenes/botonPegasus.png");
                final JButton DragPegasus = new JButton(botonPegasus);
                creadoPegasus = true;
                contadorObjeto++;
                System.out.println(contadorObjeto);
                DragPegasus.setSize(botonPegasus.getIconWidth(), botonPegasus.getIconHeight());
                DragPegasus.setContentAreaFilled(false);
                DragPegasus.setBorder(null);
                GUI.dibujo.add(DragPegasus);
                DragPegasus.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent m) {
                        DragPegasus.setBounds(m.getX(), m.getY(), botonPegasus.getIconWidth(), botonPegasus.getIconHeight());
                        GUI.dibujo.repaint();

                    }

                    @Override
                    public void mouseDragged(MouseEvent m) {

                        if (creadoPegasus != false) {
                            System.out.println("Estoy vivito");
                            DragPegasus.setBounds(m.getX(), m.getY(), botonPegasus.getIconWidth(), botonPegasus.getIconHeight());
                            creadoPegasus = false;
                        }
                        valorx = (m.getX() / 2) + valorx;
                        valory = (m.getY() / 2) + valory;
                        posicionPegasusX = valorx;
                        posicionPegasusY = valory;
                        System.out.println(valorx + " , " + valory);
                        DragPegasus.setLocation(valorx, valory);
                        GUI.dibujo.repaint();
                    }
                });
            }
        });

        stock = new JButton(s);
        stock.setContentAreaFilled(false);
        stock.setBorder(null);
        
        //stock.setEnabled(false);
        stock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                stock.setEnabled(false);
                final ImageIcon botonStock = new ImageIcon("src/imagenes/botonStock.png");
                final JButton DragStock = new JButton(botonStock);
                creadoStock = true;
                contadorObjeto++;
                System.out.println(contadorObjeto);
                DragStock.setSize(botonStock.getIconWidth(), botonStock.getIconHeight());
                DragStock.setContentAreaFilled(false);
                DragStock.setBorder(null);
                GUI.dibujo.add(DragStock);
                DragStock.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent m) {

                        DragStock.setBounds(m.getX(), m.getY(), botonStock.getIconWidth(), botonStock.getIconHeight());
                        GUI.dibujo.repaint();

                    }

                    @Override
                    public void mouseDragged(MouseEvent m) {

                        if (creadoStock != false) {
                            System.out.println("Estoy vivito");
                            DragStock.setBounds(m.getX(), m.getY(), botonStock.getIconWidth(), botonStock.getIconHeight());
                            creadoStock = false;
                        }
                        valorx = (m.getX() / 2) + valorx;
                        valory = (m.getY() / 2) + valory;
                        posicionStockX = valorx;
                        posicionStockY = valory;
                        System.out.println(valorx + " , " + valory);
                        DragStock.setLocation(valorx, valory);
                        GUI.dibujo.repaint();

                    }

                });

            }
        });

//        sheldon = new JButton(sc);
//        sheldon.setContentAreaFilled(false);
//        sheldon.setBorder(null);
//        sheldon.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//
        final ImageIcon botonSheldon = new ImageIcon("src/imagenes/botonSheldon.png");
        final JButton DragSheldon = new JButton(botonSheldon);
        creadoSheldon = true;
        contadorObjeto++;
        System.out.println(contadorObjeto);
        DragSheldon.setSize(botonSheldon.getIconWidth(), botonSheldon.getIconHeight());
        DragSheldon.setContentAreaFilled(false);
        DragSheldon.setBorder(null);
        GUI.dibujo.add(DragSheldon);
        DragSheldon.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent m) {
                DragSheldon.setBounds(500, 400, botonSheldon.getIconWidth(), botonSheldon.getIconHeight());
                GUI.dibujo.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent m) {

                if (creadoSheldon != false) {
                    System.out.println("Estoy vivito");
//                    DragSheldon.setBounds(m.getX(), m.getY(), botonSheldon.getIconWidth(), botonSheldon.getIconHeight());
                    DragSheldon.setBounds(500, 400, botonSheldon.getIconWidth(), botonSheldon.getIconHeight());
                    creadoSheldon = false;
                }
                valorx = (m.getX() / 2) + valorx;
                valory = (m.getY() / 2) + valory;
                posicionSheldonX = valorx;
                posicionSheldonY = valory;
                //System.out.println(valorx + " , " + valory);
                DragSheldon.setLocation(valorx, valory);
                GUI.dibujo.repaint();

            }

        });
//        });

//        ventana.setVisible(true);
//        ventana.setSize(new Dimension(800, 600));
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        ventana.setResizable(false);
        areaBotones.add(coliseo);
        // areaBotones.add(torre);
        areaBotones.add(ufo);
        areaBotones.add(pegasus);
        areaBotones.add(stock);
//        areaBotones.add(sheldon);
        areaBotones.setLayout(new GridLayout(1, 4));
        GUI.ventana.add(areaBotones, BorderLayout.NORTH);
        GUI.ventana.add(GUI.dibujo, BorderLayout.CENTER);
        
        if(ConectSerialPortBidericcional.contadorNivel == 4){
            coliseo.setEnabled(true);
            ufo.setEnabled(true);
            stock.setEnabled(true);
        }else{
            coliseo.setEnabled(false);
        }
        if(ConectSerialPortBidericcional.contadorNivel == 3){
            ufo.setEnabled(true);
            stock.setEnabled(true);
        }else{
            ufo.setEnabled(false);
        }
        if(ConectSerialPortBidericcional.contadorNivel == 2){
            stock.setEnabled(true);
        }else{
            stock.setEnabled(false);
        }
    }
}
