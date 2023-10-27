package model.Decorator;

public class SuperAttack extends Decorator{

	public SuperAttack(ISkill skill) {
		super(skill);
	}
	
	@Override
	public void operation() {
		super.operation();
		Player player = Player.getInstance(200, 200, null);
		player.setDamage(6);
	}
}
