package Vistas;

import Logica.CuboPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Prota extends JPanel {
    private CuboPlayer cp;
    public Prota() {
        super();

        cp = new CuboPlayer();

        setSize(30,30);
        setBackground(cp.getColor());
        setFocusable(true);
    }

    public boolean isJumping() {
        return cp.isSaltando();
    }
    public void jump(boolean p) {
        cp.setSaltando(p);
    }
    public int getPoints() {
        return cp.getPoints();
    }
    public void addPoints() {
        cp.addPoints();
    }
    public void saltar(PanelPrincipal pp) {
        setLocation(50, pp.ALTURA - 130);
        jump(true);
        Timer timer = new Timer(10, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x <= 30) {
                    setLocation(50, pp.ALTURA - 130 - x * 2);
                } else if(x > 40) {
                    setLocation(50, pp.ALTURA - 190 + (x - 40) * 2);
                }
                x++;
                if(x == 70 || !isJumping()) {
                    setLocation(50, pp.ALTURA - 130);
                    jump(false);
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
