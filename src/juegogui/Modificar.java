package juegogui;

import java.io.*;
import java.util.LinkedList;

/**
 *
 * @author Elkin
 */
public class Modificar {
    
    LinkedList<RankingClass> lista = new LinkedList<>();

    public Modificar() {
    }

    public void leer() {
        try {
            Object auxiliar;
            ObjectInputStream lectura;
            lectura = new ObjectInputStream(new FileInputStream("Ranking.fong"));
            int contador = 0;
            while ((auxiliar = lectura.readObject()) != null) {
                lista.add((RankingClass) auxiliar);
                System.out.println("Archivo Leido " + contador);
                contador++;
//                if (auxiliar instanceof RankingClass) {
//                   
//                }
            }
            lectura.close();
        } catch (Exception e) {
            System.out.println("Error De Lectura, Producido Por No tener Un archivo Escrito");
        }
    }

    public void escribir() {
        try {
            ObjectOutputStream escritura;
            escritura = new ObjectOutputStream(new FileOutputStream("Ranking.fong"));
            int contador = 0;
            //escritura.writeObject(lista.get(contador));
            for (RankingClass lista1 : lista) {
                escritura.writeObject(lista.get(contador));
//                escritura.writeObject("\r\n");
                contador++;
            }
            escritura.close();
        } catch (Exception e) {
        }
        System.out.println("El archivo se ha escrito");
    }

    public void top() {
        RankingClass copia;
        int contador = 0;
        String resultado = " No cogio";
        for (int f = 0; f < lista.size() - 1; f++) {
            for (int i = f + 1; i < lista.size(); i++) {
                System.out.println(contador);
                if (lista.get(f).getPuntaje() < lista.get(i).getPuntaje()) {
                    System.out.println(i);
                    copia = lista.get(i);
                    lista.set(i, lista.get(f));
                    lista.set(f, copia);
                    contador++;
                }
            }
        }
        System.out.println("Tengo " + lista.size() + " elementos");
    }

    public String imprimir() {
        String imprimir = "";
        for (int i = 0; i < Inicio.manejo.lista.size(); i++) {
            imprimir += "Posicion (" + (i + 1) + ") Nombre: " + Inicio.manejo.lista.get(i).getNombre() + " Puntaje: " + Inicio.manejo.lista.get(i).getPuntaje() + "<br>";
            System.out.println(Inicio.manejo.lista.get(i).getNombre());
            System.out.println(Inicio.manejo.lista.get(i).getPuntaje());
        }
        return imprimir;
    }
}
