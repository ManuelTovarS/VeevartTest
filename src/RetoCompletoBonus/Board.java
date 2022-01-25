/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoCompletoBonus;

/**
 * Clase que moldea la informacion para crear el Tablero
 *
 * @author manueljosetovarsanchez
 */
public class Board {

    public int dimensionBoard;

    /**
     * Metodo constructor que inicializa la dimension del tablero
     *
     * @param dimensionBoard Entero posicion del Jugador
     */
    public Board(int dimensionBoard) {
        this.dimensionBoard = dimensionBoard;
    }

    /**
     * Metodo que crea el tablero (arreglo de cadenas) segun la dimension
     * ingresada y teniendo en cuenta un plano o base
     *
     * @param dimension Entero posicion del Jugador
     * @return Tablero (array) con dimension
     */
    public String[] boardCreation(int dimension) {

        String[] boardBluePrint
                = {
                    "0:Inicio",
                    "1", "2", "3:Escalera + 8", "4", "5",
                    "6:Escalera + 11", "7", "8", "9:Escalera + 9", "10:Escalera + 2",
                    "11", "12", "13", "14:Serpiente - 10", "15",
                    "16", "17", "18", "19:Serpiente - 11", "20",
                    "21", "22:Serpiente - 2", "23", "24:Serpiente - 8", "25"
                };

        switch (dimension) {
            case 1 ->
                dimension = 5 * 5;
            case 2 ->
                dimension = 6 * 6;
            case 3 ->
                dimension = 7 * 7;
            default -> {
            }
        }

        String[] board = new String[dimension + 1];

        for (int i = 0; i < board.length; i++) {

            if (i < 25) {
                board[i] = boardBluePrint[i];
            } else {
                board[i] = Integer.toString(i);
            }
        }

        return board;
    }

    //No alcance a implementar esta parte del codigo pero lo que seguiria es 
    //llamar el metodo que crea el tablero en la clase Game  y modificar alguna
    //condiciones para su correcto funcionamiento
}
