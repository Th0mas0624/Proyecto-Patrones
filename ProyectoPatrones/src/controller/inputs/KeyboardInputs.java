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
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W:
			case KeyEvent.VK_A:
			case KeyEvent.VK_D:
			case KeyEvent.VK_S:
			case KeyEvent.VK_Z:
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			gamePanel.player.jump(-20);
			break;
		case KeyEvent.VK_A:
			gamePanel.player.changeXDelta(-5);
			break;
		case KeyEvent.VK_S:
			gamePanel.player.changeYDelta(5);
			break;
		case KeyEvent.VK_D:
			gamePanel.player.changeXDelta(5);
			break;
		case KeyEvent.VK_Z:
			gamePanel.player.shoot();
			break;
		}

	}



}