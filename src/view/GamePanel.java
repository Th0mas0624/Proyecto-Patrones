package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import model.Decorator.Player;

public class GamePanel extends JPanel{
	
	public Player player = Player.getInstance(100, 100);
	
	
	public GamePanel() {
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));

	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1200, 700);
		setPreferredSize(size);
	}	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(player.xPosition, player.yPosition, 200, 50);
		repaint();

	}

	

}
