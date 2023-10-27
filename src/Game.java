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
		player = player.getInstance(150, Constans.FIRST_FLOOR);
	}

}
