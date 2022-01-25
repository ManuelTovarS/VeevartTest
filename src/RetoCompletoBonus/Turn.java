/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoCompletoBonus;

/**
 *
 * @author manueljosetovarsanchez
 */
public class Turn {

    public int scoreDice;
    public int movePosition;

    public Turn() {

    }

    /**
     * Metodo que se ejecuta cada turno por Jugador y representa el valor
     * obtenido por el dado, dicho valor se almacena en la variable scoreDice y
     * asegura que el valor que pueda obtener este entre 1 y 6
     */
    public void diceThrow() {
        scoreDice = (int) (Math.random() * (1 - 7) + 7);
    }

    /**
     * @param board[] Arreglo de cadena que representa el tablero por donde se
     * va a mover el jugador.
     * @param lastPosition Entero que representa la casilla donde se encuentra
     * el jugador.
     * @return movePosition Entero que representa la nueva casilla en el que el
     * jugador cayo.
     *
     * Método que se encarga de mover el jugador y actualizar su posicion en su
     * turno por el tablero, segun la casilla de ultima posición. Asi mismo,
     * tiene en cuenta si supero la meta para poder aplicar la penalizacion
     * mediante el metodo spot() valida si en la casilla que cayo es una
     * escalera o serpiente.
     */
    public int moveTurn(String board[], int lastPosition) {
        try {
            System.out.println("----------------------------");
            System.out.println("La casilla donde esta antes del turno es: " + lastPosition);
            System.out.println("El dado cayo en: " + scoreDice);
            System.out.println("Se mueve a la casilla: " + (lastPosition + scoreDice));
            spot(board, (lastPosition + scoreDice));
        } catch (ArrayIndexOutOfBoundsException e) {
            int penalizacion = (lastPosition + scoreDice) - 25;
            movePosition = 25 - penalizacion;
            System.out.println("Se penalizo por exceso y ahora la ultima posicion es: " + movePosition);
            spot(board, movePosition);
        }
        System.out.println("Termino el turno y esta en la posicion: " + movePosition);
        System.out.println("----------------------------");
        return movePosition;
    }

    /**
     * @param board[] Arreglo de cadena que representa el tablero por donde se
     * mueve y contiene las escaleras o serpientes
     * @param move Entero que representa la cantidad de casillas que se mueve el
     * Jugador teniendo en cuenta su la posicion donde se movera o la
     * penalizacion
     * @return movePosition Entero que representa la nueva casilla en el que el
     * jugador cayo, teniendo en cuenta si la casilla fue serpiente o escalera.
     * Metodo auxiliar para la correcta ejecucion de moveTurn
     */
    public int spot(String[] board, int move) {
        if (board[move].contains(":")) {
            String[] partes = board[move].split(":");
            String[] movimiento = partes[1].split(" ");
            int casilla = Integer.parseInt(partes[0]);
            String operacion = movimiento[0];
            int cantidad = Integer.parseInt(movimiento[2]);
            if ("Escalera".equals(operacion)) {
                System.out.println("Tiene Escalera");
                movePosition = casilla + cantidad;
                System.out.println("Subio a: " + movePosition);
            } else {
                System.out.println("Tiene Serpiente");
                movePosition = casilla - cantidad;
                System.out.println("Bajo a: " + movePosition);
            }
        } else {    
            System.out.println("NO tiene Escalera ni Serpiente");
            movePosition = Integer.parseInt(board[move]);
        }
        return movePosition;
    }

}
