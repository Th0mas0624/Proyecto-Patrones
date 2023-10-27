package view;

import java.awt.*;

import javax.swing.*;

import controller.inputs.KeyboardInputs;
import model.AbstractFactory.AbstractCharacter;
import model.entitys.Background;
import model.entitys.Player;

public class GamePanel extends JPanel{
	private ImageIcon playerImage; // Variable para la imagen del jugador
	private ImageIcon backgroundImage, bulletImage;
	private Background background = new Background();
	private boolean Zpress = false;
	public Player player;
	private AbstractCharacter c;

	public GamePanel(Player player) {

		setPanelSize();
		this.player = player;
		// Carga la imagen del jugador desde un archivo (ajusta la ruta según tu imagen)
		playerImage = new ImageIcon(this.player.getC().createWeapon().getWeapon());
		backgroundImage = new ImageIcon("assets/NES-Contra-Level1.png");
		bulletImage = new ImageIcon(player.m.getBullet("bullet").getImagen());
		addKeyListener(new KeyboardInputs(this));
		setFocusable(true);
	}

	private void setPanelSize() {
		Dimension size = new Dimension(1200, 700);
		setPreferredSize(size);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Calcula el ancho de la imagen de fondo para mantener la proporción
		int newWidth = (int) (backgroundImage.getIconWidth() * ((double)getHeight() / backgroundImage.getIconHeight()));
		
		// Dibuja la imagen de fondo
		g.drawImage(backgroundImage.getImage(), Background.x, 0, newWidth, getHeight(), this);
		// Escala el ImageIcon del jugador al nuevo tamaño
		int newPlayerWidth = 75; // Nueva anchura del jugador en píxeles
		int newPlayerHeight = 75; // Nueva altura del jugador en píxeles
		ImageIcon scaledPlayerIcon = new ImageIcon(playerImage.getImage().getScaledInstance(newPlayerWidth, newPlayerHeight, Image.SCALE_DEFAULT));
		ImageIcon scaledbulletIcon = new ImageIcon(bulletImage.getImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT));
		bulletImage.paintIcon(this, g, 200, 200);
		// Pinta el ImageIcon escalado del jugador
		if(player.xPosition>570){
			scaledPlayerIcon.paintIcon(this, g, 570, this.player.yPosition);
		}else{
			scaledPlayerIcon.paintIcon(this, g, this.player.xPosition, this.player.yPosition);
		}

		if(Zpress == true){
				scaledbulletIcon.paintIcon(this, g, (int)player.m.getX() + player.xPosition, player.yPosition);
		}

		player.gravity();
		background.refresh_background();
		repaint();
	}
	
	public void setZPress(boolean Zpress){
		this.Zpress = Zpress;
	}

	public boolean getZPress(){
		return this.Zpress;
	}


}
