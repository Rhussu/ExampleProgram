package Vistas;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelPrincipal pp;

    public Ventana() {
        super();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("GeometryCopy");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pp = new PanelPrincipal();

        add(pp);
        pack();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
