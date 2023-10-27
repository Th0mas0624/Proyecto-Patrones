package model.Decorator;

public class SuperAttack extends Decorator{

	public SuperAttack(ISkill skill) {
		super(skill);
	}
	
	@Override
	public void operation() {
		super.operation();
		//Realizar implementacion
	}
}
