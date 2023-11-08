package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.ButtonsController;

public class SelectPlayer extends JPanel {
    private JButton playerButton1;
    private JButton playerButton2;
    private GameFrame gameFrame;
    private ButtonsController buttonsController;

    public SelectPlayer(ButtonsController buttonsController, GameFrame gameFrame) {
        this.buttonsController = buttonsController;
        configureLayout();
        createPlayerButtons();
        setPanelSize();
    }

    private void configureLayout() {
        setLayout(new GridLayout(1, 2));
    }

    private void createPlayerButtons() {
        playerButton1 = createPlayerButton("Player 1", "assets/player_sprite.png");
        playerButton2 = createPlayerButton("Player 2", "assets/player_sprite1.png");
        addPlayerButtonsToPanel();
    }

    private JButton createPlayerButton(String label, String imagePath) {
        ImageIcon playerImage = new ImageIcon(imagePath);
        JButton playerButton = new JButton(label, playerImage);
        playerButton.setBackground(Color.BLACK);
        playerButton.setForeground(Color.black);
        playerButton.addActionListener(buttonsController);
        return playerButton;
    }

    private void addPlayerButtonsToPanel() {
        add(playerButton1);
        add(playerButton2);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1200, 700);
        setPreferredSize(size);
    }
}
