package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import controller.inputs.KeyboardInputs;
import model.Flyweight.*;
import model.entitys.Background;
import model.entitys.Player;

public class GamePanel extends JPanel {
    public ImageIcon playerImage; // Variable para la imagen del jugador
    private ImageIcon backgroundImage;
    private Background background = new Background();
    public Player player = Player.getInstance(100, 100);
    private ImageIcon scaledPlayerIcon; // Variable para la imagen escalada del jugador

	// Disparar
	private ArrayList<MovingBullet> bullets = new ArrayList<>();
    public boolean isZPressed = false; // Para controlar el disparo con la tecla Z
	private ImageIcon bulletImage;
	private ImageIcon scaledBulletIcon;

    public GamePanel() {
        loadAssets();
        setPanelSize();
        initializeScaledPlayerIcon(); // Inicializa la imagen escalada del jugador
		initializeScaledBulletIcon();
        addKeyListener(new KeyboardInputs(this));
    }

    private void loadAssets() {
        playerImage = new ImageIcon("assets/player_sprite.png");
        backgroundImage = new ImageIcon("assets/NES-Contra-Level1.png");
		bulletImage = new ImageIcon("assets/bullet.png");
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1200, 700);
        setPreferredSize(size);
    }

    private void initializeScaledPlayerIcon() {
        int newPlayerWidth = 75;
        int newPlayerHeight = 75;
        Image scaledImage = playerImage.getImage().getScaledInstance(newPlayerWidth, newPlayerHeight, Image.SCALE_DEFAULT);
        scaledPlayerIcon = new ImageIcon(scaledImage);
    }
	private void initializeScaledBulletIcon(){
		 // Escala la imagen de la bala mientras mantiene la relación de aspecto
		 int bulletWidth = 15; // Define el ancho deseado de la bala
		 int bulletHeight = (int) (bulletWidth * (double) bulletImage.getIconHeight() / bulletImage.getIconWidth());
		 Image scaledImage = bulletImage.getImage().getScaledInstance(bulletWidth, bulletHeight, Image.SCALE_DEFAULT);
		 scaledBulletIcon = new ImageIcon(scaledImage);
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		drawPlayer(g);
		updateGameObjects();
		handleBullets(g);
		repaint();
	}
	
	private void handleBullets(Graphics g) {
		if (isZPressed) {
			clearBullets();
			addBullet(player.xPosition, player.yPosition);
		}
	
		ArrayList<MovingBullet> bulletsToRemove = new ArrayList<>();
		for (MovingBullet movingBullet : bullets) {
			movingBullet.move();
			drawBullet(g, movingBullet);
	
			if (bulletOutOfPanel(movingBullet)) {
				bulletsToRemove.add(movingBullet);
			}
		}
	
		removeBullets(bulletsToRemove);
	}
	
	private void clearBullets() {
		bullets.clear();
	}
	
	private void addBullet(float x, float y) {
		MovingBullet movingBullet = new MovingBullet(x, y);
		bullets.add(movingBullet);
	}
	
	private boolean bulletOutOfPanel(MovingBullet bullet) {
		return bullet.getX() > getWidth();
	}
	
	private void removeBullets(ArrayList<MovingBullet> bulletsToRemove) {
		bullets.removeAll(bulletsToRemove);
	}
	
	private void drawBullet(Graphics g, MovingBullet movingBullet) {
		g.drawImage(scaledBulletIcon.getImage(), (int) movingBullet.getX(), (int) movingBullet.getY(), this);
	}
	

    private void drawBackground(Graphics g) {
        int newWidth = (int) (backgroundImage.getIconWidth() * ((double) getHeight() / backgroundImage.getIconHeight()));
        g.drawImage(backgroundImage.getImage(), Background.x, 0, newWidth, getHeight(), this);
    }

    private void drawPlayer(Graphics g) {
        int xPosition = player.xPosition > 570 ? 570 : player.xPosition;
        scaledPlayerIcon.paintIcon(this, g, xPosition, player.yPosition);
    }

    private void updateGameObjects() {
        // Sprite del jugador, confirmar que sea válido
        if (this.player.getC().createWeapon().getWeapon() != null) {
            this.playerImage = new ImageIcon(this.player.getC().createWeapon().getWeapon());
        }
		initializeScaledPlayerIcon();

        player.gravity();
        background.refreshBackground();
    }
}
