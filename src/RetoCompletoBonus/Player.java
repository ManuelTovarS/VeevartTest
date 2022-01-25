/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoCompletoBonus;

/**
 * Clase que moldea la informacion necesaria para un Jugador
 * @author manueljosetovarsanchez
 */
public class Player {

    public int lastPosition;

    /**
     * Metodo constructor que inicializa la posicion de un jugador 
     * @param lastPosition Entero posicion del Jugador
     */
    public Player(int lastPosition) {
        this.lastPosition = lastPosition;
    }

    /**
     * Metodo para obtener la posicion del jugador
     */
    public int getLastPosition() {
        return lastPosition;
    }

    /**
     * Metodo para cambiar la posicion del jugador
     * @param lastPosition Entero posicion del jugador
     */
    public void setLastPosition(int lastPosition) {
        this.lastPosition = lastPosition;
    }

}
