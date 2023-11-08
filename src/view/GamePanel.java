package view;

import java.awt.*;

import javax.swing.*;

import controller.inputs.KeyboardInputs;
import model.entitys.Background;
import model.entitys.Player;

public class GamePanel extends JPanel{
	public ImageIcon playerImage; // Variable para la imagen del jugador
	private ImageIcon backgroundImage;
	private Background background = new Background();
	public Player player = Player.getInstance(100, 100);

	


	public GamePanel() {
        loadAssets();
        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
    }

	private boolean Zpress = false;
	public void setZPress(boolean Zpress){
		this.Zpress = Zpress;
	}

	public boolean getZPress(){
		return this.Zpress;
	}

    private void loadAssets() {
        playerImage = new ImageIcon("assets/player_sprite.png");
        backgroundImage = new ImageIcon("assets/NES-Contra-Level1.png");
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1200, 700);
        setPreferredSize(size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawPlayer(g);
        updateGameObjects();
        repaint();
    }

    private void drawBackground(Graphics g) {
        int newWidth = (int) (backgroundImage.getIconWidth() * ((double) getHeight() / backgroundImage.getIconHeight()));
        g.drawImage(backgroundImage.getImage(), Background.x, 0, newWidth, getHeight(), this);
    }

    private void drawPlayer(Graphics g) {
        int newPlayerWidth = 75;
        int newPlayerHeight = 75;
        Image scaledPlayerImage = playerImage.getImage().getScaledInstance(newPlayerWidth, newPlayerHeight, Image.SCALE_DEFAULT);
        ImageIcon scaledPlayerIcon = new ImageIcon(scaledPlayerImage);
        int xPosition = player.xPosition > 570 ? 570 : player.xPosition;
        scaledPlayerIcon.paintIcon(this, g, xPosition, player.yPosition);
    }

    private void updateGameObjects() {
		if (this.player.getC().createWeapon().getWeapon() != null){
			this.playerImage = new ImageIcon(this.player.getC().createWeapon().getWeapon());
		}
        player.gravity();
        background.refreshBackground();
    }
}
