/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import java.util.ArrayList;
import java.util.Random;

/**
 * Clase de utilidades.
 * @author Diego V., Franklin C., Dayana T., Carlos V., Mia N.
 * @version 1.0
 */
public class Ruleta {
    /**
 * array para contener numeros
 */
    public ArrayList<Integer> numeros;
    
        /**
 * generador de random
 */
    public Random aleatorio;
    /**
 * constuctor
 */
    public Ruleta() {
        aleatorio = new Random();
        numeros = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            numeros.add(i);
        }
    }
    
    
    /**
 * metodo para obtener un numero 
 * @return numero que representa un numero entre 1 a 4
 */
    public int obtenerNumero() {
        if (numeros.isEmpty()) {
            throw new IllegalStateException("Se llego al limite de generacion de numeros");
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