package controller.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.GamePanel;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.player.jump();
			System.out.println(gamePanel.player.yPosition);
			break;
		case KeyEvent.VK_A:
			gamePanel.player.changeXDelta(-5);
			System.out.println(gamePanel.player.xPosition);
			break;
		case KeyEvent.VK_S:
			gamePanel.player.changeYDelta(5);
			System.out.println(gamePanel.player.yPosition);
			break;
		case KeyEvent.VK_D:
			gamePanel.player.changeXDelta(5);
			System.out.println(gamePanel.player.xPosition);

			break;
		}

	}



}