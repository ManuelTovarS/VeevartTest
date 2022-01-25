/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RetoCompletoBonus;

import java.util.Scanner;

/**
 * Clase main que ejecuta el juego
 *
 * @author manueljosetovarsanchez
 */
public class Game {

    public static int numberPlayers;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Escaner que detecta y almacena en la variable numberPlayers el numero
         * de jugadores que van a Jugar
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa el numero de jugadores:");
        numberPlayers = scan.nextInt();

        /**
         * Declaración de Arreglo de Jugadores que almacena su posicion y se
         * dimensiona segun el numero de jugadores que jugaran
         */
        Player[] players = new Player[numberPlayers];
        /**
         * Instancia de cada uno los jugadores e inicializacion de su posicion
         * inicial
         */
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(0);
        }
        /**
         * Instancia de gameTurn de la clase Turn par acceder a sus metodos
         */
        Turn gameTurn = new Turn();

        String[] board
                = {
                    "0:Inicio",
                    "1", "2", "3:Escalera + 8", "4", "5",
                    "6:Escalera + 11", "7", "8", "9:Escalera + 9", "10:Escalera + 2",
                    "11", "12", "13", "14:Serpiente - 10", "15",
                    "16", "17", "18", "19:Serpiente - 11", "20",
                    "21", "22:Serpiente - 2", "23", "24:Serpiente - 8", "25"
                };

        int hightPosition = 0;

        do {

            for (int i = 0; i < players.length; i++) {

                System.out.println("El Jugador " + i + " lanzo el dado");
                gameTurn.diceThrow();
                players[i].setLastPosition(gameTurn.moveTurn(board, players[i].getLastPosition()));
                hightPosition = players[i].getLastPosition();

                if (hightPosition == 25) {
                    System.out.println("El jugador " + i + " ha ganado el juego");
                    break;
                }

            }

        } while (hightPosition < board.length - 1);

    }

}
