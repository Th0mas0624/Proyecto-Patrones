package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import model.Decorator.Player;
import model.Flyweight.MovingBullet;

public class GamePanel extends JPanel{
	
	public Player player = Player.getInstance(100, 100);
	private Image playerImage, bulletImage;
	
	public GamePanel() {
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		createImage();
	}
	
	public void createImage() {
		//Player Image
		ImageIcon icon = new ImageIcon(player.getC().createWeapon().getWeapon());
		playerImage = icon.getImage();
        // Cambiar el tamaño de la imagen (por ejemplo, a 100x100 píxeles)
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
		g.drawImage(playerImage, player.xPosition, player.yPosition, this);
		g.drawImage(bulletImage, player.m.getX(), player.m.getY(), this);
		repaint();

	}

	

}
