import model.Decorator.Player;
import view.GameFrame;
import view.GamePanel;

public class Game {
	
	private Player player;
	
	public Game() {
		GamePanel jp = new GamePanel();
		GameFrame jf = new GameFrame(jp);
		jp.requestFocus();
	}
	
	private void initClasses() {
		player = player.getInstance(200, 200);
	}

}
