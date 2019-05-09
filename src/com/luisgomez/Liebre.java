package com.luisgomez;

import java.util.Random;

public class Liebre implements Runnable {


    private String nombre;

    private int casillas;

    private long initialTime;

    private int tiempoEntreHilos = 1;


    public Liebre(String nombre, int casillas) {
        this.nombre = nombre;
        this.casillas = casillas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCasillas() {
        return casillas;
    }

    public void setCasillas(int casillas) {
        this.casillas = casillas;
    }

    @Override
    public void run() {


        while (casillas < 10) {


            try {

                Thread.sleep(1000);

                // EXPLICACION (*)

                Random random = new Random();

                int numRandom = random.nextInt(100) + 1; // Genera desde 0 a 99, (el 100 no lo incluye, por tanto le sumamos 1
                // asi obtenemos numeros aleatorios desde 1 hasta 100


                if (numRandom > 0 && numRandom <= 20) {

                    casillas += 0;

                } else if (numRandom > 20 && numRandom <= 40) {

                    casillas += 9;

                } else if (numRandom > 20 && numRandom <= 40) {

                    casillas += 9;

                } else if (numRandom > 40 && numRandom <= 50) {

                    casillas -= 12;

                } else if (numRandom > 50 && numRandom <= 80) {

                    casillas += 1;

                } else if (numRandom > 80 && numRandom <= 100) {

                    casillas -= 2;

                }

                // Para que no haya valores por debajo de cero
                if (casillas < 0) {

                    casillas = 0;
                }

                // LLamamos al metodo para que aplique e tiempo de espera para volver a imprimir

               // this.esperarXsegundos(tiempoEntreHilos);

                // Con this.getName, obtenemos el nombre de la clase como otras veces, pero en este caso casi q ponerlo a mano

                System.out.println("La Liebre " + " - " + casillas + " casillas.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        // Si ha llegado a 70 casillas entonces imprime que ha terminado

        System.out.println("La Liebre ha llegado a la meta ");
    }


    /*
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    */
}
