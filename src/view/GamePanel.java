package view;

import java.awt.*;

import javax.swing.*;

import controller.inputs.KeyboardInputs;
import model.Decorator.Player;

public class GamePanel extends JPanel{
	private ImageIcon playerImage; // Variable para la imagen del jugador
	private ImageIcon backgroundImage;


	public Player player = Player.getInstance(100, 100);


	public GamePanel() {
		setPanelSize();

		// Carga la imagen del jugador desde un archivo (ajusta la ruta según tu imagen)
		playerImage = new ImageIcon("assets/player_sprite.png");
		backgroundImage = new ImageIcon("assets/NES-Contra-Level1.png");

		addKeyListener(new KeyboardInputs(this));

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
		g.drawImage(backgroundImage.getImage(), 0, 0, newWidth, getHeight(), this);
		
		// Escala el ImageIcon del jugador al nuevo tamaño
		int newPlayerWidth = 75; // Nueva anchura del jugador en píxeles
		int newPlayerHeight = 75; // Nueva altura del jugador en píxeles
		ImageIcon scaledPlayerIcon = new ImageIcon(playerImage.getImage().getScaledInstance(newPlayerWidth, newPlayerHeight, Image.SCALE_DEFAULT));
		
		// Pinta el ImageIcon escalado del jugador
		scaledPlayerIcon.paintIcon(this, g, player.xPosition, player.yPosition);
	}
	





}
