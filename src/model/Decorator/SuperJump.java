package model.Decorator;

public class SuperJump extends Decorator{

	public SuperJump(ISkill skill) {
		super(skill);
	}
	
	@Override
	public void operation() {
		super.operation();
		//Realizar implementacion
	}
}
