package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Decorator.Player;

public class PlayerController implements KeyListener{

	Player player;
	
	public PlayerController(Player player) {
		this.player = player;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public JLabel obtenerPanel() {
		ImageIcon image = new ImageIcon(player.m.getBullet(1).getImagen());
		JLabel label = new JLabel(image);
		
		return label;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
            player.jump();
            break;
        case KeyEvent.VK_A:
            player.moveLeft();
            break;
        case KeyEvent.VK_D:
            player.moveRight();
            break;
        case KeyEvent.VK_Z:
            player.shoot();
            obtenerPanel().setBounds(player.m.getX(), player.m.getY(),2,2);
            break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
        case KeyEvent.VK_A:
        case KeyEvent.VK_D:
        case KeyEvent.VK_Z:
       
    }
		
	}

}
