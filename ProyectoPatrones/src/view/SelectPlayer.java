package view;

import javax.swing.JPanel;

import controller.ButtonsCrontroller;

import javax.swing.*;
import java.awt.*;

public class SelectPlayer extends JPanel {

    private JButton button1;
    private JButton button2;
    private ButtonsCrontroller e;

    public SelectPlayer(ButtonsCrontroller e) {
        this.e = e;

        // Configura el layout del panel
        setLayout(new GridLayout(1, 2));

        // Crea los botones y asigna imágenes
        ImageIcon image1 = new ImageIcon("Pictures/Man/1.png"); // Cambia la ruta a tu imagen
        button1 = new JButton("1", image1);

        ImageIcon image2 = new ImageIcon("Pictures/Women/1.png"); // Cambia la ruta a tu imagen
        button2 = new JButton("2", image2);

        // Agrega ActionListener a los botones
        button1.addActionListener(e);
        button2.addActionListener(e);

        // Agrega los botones al panel
        add(button1);
        add(button2);
    }
}
