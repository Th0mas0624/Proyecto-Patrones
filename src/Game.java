import helps.Constans;
import model.entitys.Player;
import view.GameFrame;
import view.GamePanel;

public class Game {
	
	private Player player;
	
	public Game() {
		initClasses();
		GamePanel jp = new GamePanel();
		GameFrame jf = new GameFrame(jp);
		jp.requestFocus();
	}
	
	private void initClasses() {
		// Posición inicial del jugador
		player = player.getInstance(150, Constans.FIRST_FLOOR);

		// Se agrega lo siguiente para evitar que se bloquee el movimiento al empezar
		player.jump();;
	}

}
