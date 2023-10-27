import controller.ButtonsController;
import helps.Constans;
import model.entitys.Player;
import view.GameFrame;
import view.SelectPlayer;

public class Game {
	
	private Player player;
	
	public Game() {
		initClasses();
		ButtonsController e = new ButtonsController();
		SelectPlayer s = new SelectPlayer(e);
		//GamePanel jp = new GamePanel();
		GameFrame jf = new GameFrame(s);
		e.setWindow(jf);
	}
	
	private void initClasses() {
		player = player.getInstance(150, Constans.FIRST_FLOOR);
	}

	public static void main(String[] args) {
		new Game();
	}
}
