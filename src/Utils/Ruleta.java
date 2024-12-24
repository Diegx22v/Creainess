/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.ArrayList;
import java.util.Random;

public class Ruleta {
    private ArrayList<Integer> numeros;
    private Random aleatorio;

    public Ruleta() {
        aleatorio = new Random();
        numeros = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            numeros.add(i);
        }
    }

    public int obtenerNumero() {
        if (numeros.isEmpty()) {
            throw new IllegalStateException("...");
        }
        int indice = aleatorio.nextInt(numeros.size());
        int numero = numeros.get(indice);
        numeros.remove(indice);
        return numero;
    }
    
    /**
    public static void main(String[] args) {
        Ruleta ruleta = new Ruleta();

        for (int i = 0; i < 4; i++) {
            int numero = ruleta.obtenerNumero();
        }

        try {
            int numero = ruleta.obtenerNumero();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }*/
}