package model.Decorator;

public class SuperJump extends Decorator{

	public SuperJump(ISkill skill) {
		super(skill);
	}
	
	@Override
	public int operation() {
		super.operation();
		//Realizar implementacion
		return 200;
	}
}
