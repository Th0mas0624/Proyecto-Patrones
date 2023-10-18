package model.Decorator;

public class Decorator implements ISkill{
	private ISkill skill;
	
	public Decorator(ISkill skill) {
		this.skill = skill;
	}

	@Override
	public void operation() {
		this.skill.operation();
	}

}
