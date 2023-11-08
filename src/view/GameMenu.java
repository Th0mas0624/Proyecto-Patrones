package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel {
    private GameFrame gameFrame;
    private Image backgroundImage;

    public GameMenu(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        loadBackgroundImage();
        setPreferredSize(new Dimension(1200, 700));
        setupLayout();
        createPlayButton(200, 400, 400, 125);
    }

    private void loadBackgroundImage() {
        ImageIcon backgroundIcon = new ImageIcon("assets\\image_menu.png");
        backgroundImage = backgroundIcon.getImage();
    }

    private void setupLayout() {
        setLayout(null);
    }

    private void createPlayButton(int x, int y, int width, int height) {
        JButton playButton = createCustomButton("assets\\play_button.png", x, y, width, height);
        add(playButton);
    }

    private JButton createCustomButton(String imagePath, int x, int y, int width, int height) {
        JButton button = new JButton();
        setButtonAppearance(button);
        setButtonPosition(button, x, y, width, height);
        setButtonAction(button);
        setButtonIcon(button, imagePath);
        return button;
    }

    private void setButtonAppearance(JButton button) {
        button.setBackground(Color.BLACK);
        button.setBorderPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setFocusPainted(false);
    }

    private void setButtonPosition(JButton button, int x, int y, int width, int height) {
        button.setBounds(x, y, width, height);
    }

    private void setButtonAction(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.switchToGame();
            }
        });
    }

    private void setButtonIcon(JButton button, String imagePath) {
        ImageIcon buttonIcon = new ImageIcon(imagePath);
        Image scaledImage = buttonIcon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        button.setIcon(scaledIcon);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            int width = getWidth();
            int height = getHeight();
            g.drawImage(backgroundImage, 0, 0, width, height, this);
        }
    }
}