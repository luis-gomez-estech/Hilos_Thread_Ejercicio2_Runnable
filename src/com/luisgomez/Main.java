package com.luisgomez;

public class Main {

    public static void main(String[] args) {

        // Mensaje inicial

        System.out.println();

        System.out.println("¡¡Comienza la Carrera!!");

        System.out.println();

        // obtenemos el tiempo inicial

        long startTime = System.currentTimeMillis();

        // Variables que van a ir contando el tiempo de cada hilo

        long tiempoTortuga=0;
        long tiempoLiebre=0;

        //Creacion de los procesos o hilos

        Thread tortuga = new Thread(new Tortuga("Tortuga",0)); //creación del proceso tortuga1
        Thread liebre = new Thread(new Liebre("Liebre",0)); //creación del proceso liebre1


        liebre.start(); // Opcion para añadir más prioridad a la liebre, seria con liebre.setPriority(Thread.MAX_PRIORITY);
        tortuga.start();


        while (liebre.isAlive() || tortuga.isAlive()){

            long tiempo = System.currentTimeMillis() - startTime;

            if (liebre.isAlive()){
                tiempoLiebre = tiempo;
            }

            if (tortuga.isAlive()){
                tiempoTortuga = tiempo;
            }
        }


        // Una vez acaban los hilos, y dependiendo del tiempo que ha tardado cada uno en llegar, imprime quien ha ganado

        if (tiempoLiebre == tiempoTortuga){

            System.out.println("Empate");

        } else if (tiempoLiebre > tiempoTortuga){

            System.out.println("La Tortuga ha ganado la carrera");

        } else {

            System.out.println("La Liebre ha ganado la carrera");
        }

    }
}
