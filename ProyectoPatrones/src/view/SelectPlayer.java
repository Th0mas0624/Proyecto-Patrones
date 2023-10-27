package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ButtonsController;

public class SelectPlayer extends JPanel{
    private JButton button1;
    private JButton button2;
    private ButtonsController e;

    public SelectPlayer(ButtonsController e) {
        this.e = e;

        // Configura el layout del panel
        setLayout(new GridLayout(1, 2));

        // Crea los botones y asigna imágenes
        ImageIcon image1 = new ImageIcon("assets/player_sprite.png"); // Cambia la ruta a tu imagen
        button1 = new JButton("1", image1);
        button1.setBackground(Color.WHITE);
        ImageIcon image2 = new ImageIcon("assets/player_sprite1.png"); // Cambia la ruta a tu imagen
        button2 = new JButton("2", image2);
        button2.setBackground(Color.WHITE);
        // Agrega ActionListener a los botones
        button1.addActionListener(e);
        button2.addActionListener(e);

        // Agrega los botones al panel
        add(button1);
        add(button2);
    }
}
