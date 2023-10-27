import controller.ButtonsCrontroller;
import model.Decorator.Player;
import view.GameFrame;
import view.GamePanel;
import view.SelectPlayer;

public class Game {
	
	private Player player;
	
	public Game() {

		ButtonsCrontroller e = new ButtonsCrontroller();
		SelectPlayer s = new SelectPlayer(e);
		//GamePanel jp = new GamePanel();
		GameFrame jf = new GameFrame(s);
		e.setWindow(jf);
		//jp.requestFocus();
	}
	
	/*private void initClasses() {
		player = player.getInstance(200, 200);
	}*/

}
