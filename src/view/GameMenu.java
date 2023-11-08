package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel {
    public GameMenu(GameFrame gameFrame) {
        // Configura y personaliza tu menú aquí

        // Crear el botón "PLAY" y configurarlo
        JButton playButton = new JButton("PLAY");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.switchToGame(); // Cambiar al panel de juego al hacer clic en "PLAY"
            }
        });

        // Establecer el tamaño y la posición del botón para que esté centrado en el panel
        Dimension buttonSize = playButton.getPreferredSize();
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        playButton.setBounds((panelWidth - buttonSize.width) / 2, (panelHeight - buttonSize.height) / 2, buttonSize.width, buttonSize.height);

        // Agregar el botón al panel
        add(playButton);
    }
}
