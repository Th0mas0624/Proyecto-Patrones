package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import model.Decorator.Player;

public class GamePanel extends JPanel{
	
	public Player player;
	private Image playerImage, bulletImage;
	private ImageIcon backgroundImage;
	
	public GamePanel(Player player) {
		this. player = player;
		setPanelSize();
		createImage();
		backgroundImage = new ImageIcon("Pictures/Fondo/NES-Contra-Level1.png");
		addKeyListener(new KeyboardInputs(this));
		
	}
	
	public void createImage() {
		//Player Image
		ImageIcon icon = new ImageIcon(player.getC().createWeapon().getWeapon());
		playerImage = icon.getImage();
        // Cambiar el tamaño de la imagen a 100x100 píxeles
        playerImage = playerImage.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        //BulletImage
        /*player.m.getBullet("1").getImagen() lo correcto es que esto se haga directamente
         * en la clase Player ya que es la imagen de la bala del arma predeterminada
         */
        bulletImage = new ImageIcon(player.m.getBullet("1").getImagen()).getImage();
        
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1200, 700);
		setPreferredSize(size);
	}	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int newWidth = (int) (backgroundImage.getIconWidth() * ((double)getHeight() / backgroundImage.getIconHeight()));
		
		// Dibuja todas las imagenes del juego
		g.drawImage(backgroundImage.getImage(), 0, 0, newWidth, getHeight(), this);
		g.drawImage(playerImage, player.xPosition, player.yPosition, this);
		g.drawImage(bulletImage, player.m.getX(), player.m.getY(), this);
		repaint();

	}

	

}
