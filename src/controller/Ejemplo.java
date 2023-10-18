package controller;

import javax.swing.*;
import java.awt.event.*;

public class Ejemplo extends JFrame implements KeyListener {

    public Ejemplo() {
        // Configuración de la ventana y otros componentes
        // ...

        // Agregar el KeyListener a la ventana
        addKeyListener(this);

        // Asegurarse de que la ventana tenga el foco para que pueda recibir eventos de teclado
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    // Métodos de KeyListener

    @Override
    public void keyPressed(KeyEvent e) {
        // Este método se llama cuando una tecla se presiona
        int keyCode = e.getKeyCode();
        System.out.println("Tecla presionada: " + KeyEvent.getKeyText(keyCode));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Este método se llama cuando una tecla se libera
        int keyCode = e.getKeyCode();
        System.out.println("Tecla liberada: " + KeyEvent.getKeyText(keyCode));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Este método se llama cuando se ha recibido un carácter (puede no ser una tecla física)
        char keyChar = e.getKeyChar();
        System.out.println("Carácter tecleado: " + keyChar);
    }

    public static void main(String[] args) {
        Ejemplo ventana = new Ejemplo();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
    }
}
