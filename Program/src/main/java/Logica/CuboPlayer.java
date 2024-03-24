package Logica; // Para mantener el orden en los directorios

import java.awt.*; // Librería grafica

public class CuboPlayer {    // CLase principal, el archivo de llamarse igual y siempre en mayúscula
    private boolean saltando;  // -saltando(boolean)
    private int points;  // -points(int)
    private Color color;  // -color(Color)
    public CuboPlayer() {   // +CuboPlayer, el constructor el 99% de las veces tiene que ser public y siempre debe llamarse igual que la clase que representara
        points = 0;
        saltando = false;
        color = new Color(0,80,80);
    }

    public boolean isSaltando() { // + isSaltando()
        return saltando;
    }

    public void setSaltando(boolean saltando) { // setSaltando
        this.saltando = saltando;
    }

    public Color getColor() {
        return color;
    } // etc etc etc

    public int getPoints() {
        return points;
    }
    public void addPoints() {
        points++;
    }
}
