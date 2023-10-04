import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel {
    private Jugador jugador;

    public Juego() {
        jugador = new Jugador();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jugador.dibujar(g);
    }

    private class Jugador {
        private int x, y;

        public Jugador() {
            x = 50;
            y = 150;
        }

        public void dibujar(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 30, 30);
        }

        public void moverDerecha() {
            x += 5;
            repaint();
        }

        public void moverIzquierda() {
            x -= 5;
            repaint();
        }

        public void saltar() {
            y -= 30;
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            y += 30;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego");
        Juego juego = new Juego();
        frame.add(juego);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case java.awt.event.KeyEvent.VK_LEFT:
                        juego.jugador.moverIzquierda();
                        break;
                    case java.awt.event.KeyEvent.VK_RIGHT:
                        juego.jugador.moverDerecha();
                        break;
                    case java.awt.event.KeyEvent.VK_UP:
                        juego.jugador.saltar();
                        break;
                }
            }
        });
    }
}
