package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.inputs.KeyboardInputs;
import model.Decorator.Player;

public class GamePanel extends JPanel{
	
	private int xDelta = 100, yDelta = 100;
	
	public GamePanel() {
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));

	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(1200, 700);
		setPreferredSize(size);
	}
	

	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}

	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(xDelta, yDelta, 200, 50);

	}

	

}
