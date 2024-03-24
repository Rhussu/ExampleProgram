package Vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class PanelPrincipal extends JPanel {
    private int tick = 16;
    private Prota p;
    private Thread t;
    public final int ALTURA = 400;
    public final int ANCHO = 800;
    private CuboNoPlayer[] cnps = new CuboNoPlayer[2];
    private int cubosAndantes = 0;
    private Timer[] ti = new Timer[2];
    public PanelPrincipal(){
        super();
        setLayout(null);
        setBackground(Color.white);
        setPreferredSize(new Dimension(ANCHO,ALTURA));
        spawnearCubos();
        iniciarJuego();
    }

    private void iniciarJuego() {
        try {
            removeAll();
        } catch (Exception e) {
            System.out.println(" no se pudo compa");
        }
        p = new Prota();
        p.setLocation(50,ALTURA - 130);
        p.addKeyListener(new Teclas(this));
        add(p);
        p.requestFocus();
    }
    public void spawnearCubos() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    long startTime = System.currentTimeMillis(); // O también puedes usar System.currentTimeMillis();
                    repaint();
                    if((new Random()).nextInt(50) == 1) {
                        if(cubosAndantes < 2) {
                            invocarCubo();
                        }
                    }
                    try {
                        Thread.sleep(tick);
                    } catch (InterruptedException ex) {}
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    if(elapsedTime > 18) {
                        tick--;
                    } else if(elapsedTime < 14) {
                        tick++;
                    }
                    System.out.println("ticks actuales: " + tick + ", y un tiempo total de: " + elapsedTime);
                }
            }
        });
        t.start();
    }

    private void invocarCubo() {
        if (cnps[0] == null) {
            cnps[0] = new CuboNoPlayer();
            System.out.println("cubo 0 generado");
            add(cnps[0]);
            cubosAndantes++;
            ti[0] = new Timer(10, new ActionListener() {
                int x = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    x++;
                    try {
                        cnps[0].setLocation(ANCHO - x * 3, ALTURA - 130);
                        if(p.getBounds().intersects(cnps[0].getBounds())) {
                            cubosAndantes = 0;
                            cnps[0] = null;
                            cnps[1] = null;
                            System.out.println("Destruccion total desde 0");
                            iniciarJuego();
                            ti[0].stop();
                            ti[1].stop();
                        }
                        if(x == (ANCHO + 30)/3) {
                            remove(cnps[0]);
                            cubosAndantes--;
                            cnps[0] = null;
                            System.out.println("cubo 0 destruido");
                            p.addPoints();
                            ti[0].stop();
                        }
                    } catch (NullPointerException ex) {

                    }
                }
            });
            ti[0].start();
        } else if (cnps[1] == null) {
            cnps[1] = new CuboNoPlayer();
            System.out.println("cubo 1 generado");
            add(cnps[1]);
            cubosAndantes++;
            ti[1] = new Timer(10, new ActionListener() {
                int x = 0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    x++;
                    try {
                        cnps[1].setLocation(ANCHO - x * 3, ALTURA - 130);
                        if(p.getBounds().intersects(cnps[1].getBounds())) {
                            cnps[0] = null;
                            cnps[1] = null;
                            cubosAndantes = 0;
                            System.out.println("Destruccion total desde 1");
                            iniciarJuego();
                            ti[0].stop();
                            ti[1].stop();
                        }
                        if(x == (ANCHO + 30)/3) {
                            remove(cnps[1]);
                            cubosAndantes--;
                            System.out.println("cubo 1 destruido");
                            cnps[1] = null;
                            p.addPoints();
                            ti[1].stop();
                        }

                    } catch (NullPointerException ex) {

                    }
                }
            });
            ti[1].start();
        }
    }

    public Prota getP() {
        return p;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(p.getPoints() + "", 20,20);
        g2d.fillRect(0,ALTURA - 100,ANCHO,100);
    }
}
