package Vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclas implements KeyListener {
    PanelPrincipal pp;
    public Teclas(PanelPrincipal pp) {
        this.pp = pp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!pp.getP().isJumping() && (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_W)){
            pp.getP().saltar(pp);
        }
        if(pp.getP().isJumping() && e.getKeyCode() == KeyEvent.VK_S) {
            pp.getP().jump(false);
            pp.getP().setLocation(50,pp.ALTURA - 130);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
