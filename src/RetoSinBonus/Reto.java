/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package RetoSinBonus;

/**
 *
 * Clase main que ejecuta el juego
 * @author manueljosetovarsanchez
 */
public class Reto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        

         String[] board
                = {
                    "0:Inicio",
                    "1", "2", "3:Escalera + 8", "4", "5",
                    "6:Escalera + 11", "7", "8", "9:Escalera + 9", "10:Escalera + 2",
                    "11", "12", "13", "14:Serpiente - 10", "15",
                    "16", "17", "18", "19:Serpiente - 11", "20",
                    "21", "22:Serpiente - 2", "23", "24:Serpiente - 8", "25"
                };


        int lastPosition = 0;

        do {
            int scoreDice = (int) (Math.random() * (1 - 7) + 7);
            int move = lastPosition + scoreDice;

            try {
                System.out.println("La posicion en el turno es " + lastPosition);
                System.out.println("El dado cayo en: " + scoreDice);

                if (board[move].contains(":")) {
                    String[] partes = board[move].split(":");
                    String[] movimiento = partes[1].split(" ");
                    Integer casilla = Integer.parseInt(partes[0]);
                    String operacion = movimiento[0];
                    Integer cantidad = Integer.parseInt(movimiento[2]);
                    if ("Escalera".equals(operacion)) {
                        System.out.println("Tiene Escalera");
                        lastPosition = casilla + cantidad;
                        System.out.println("Subio a: " + lastPosition);
                    } else {
                        System.out.println("Tiene Serpiente");
                        lastPosition = casilla - cantidad;
                        System.out.println("Bajo a: " + lastPosition);
                    }
                } else {
                    System.out.println("NO tiene Escalera ni Serpiente");
                    lastPosition = Integer.parseInt(board[move]);
                }

                if (lastPosition == 25) {
                    System.out.println("Gano el juego");
                }

            } catch (ArrayIndexOutOfBoundsException  e) {
                System.out.println("Gano el juego por exceso");
                break;
            }

        } while (lastPosition < 25);

    }
    
}
