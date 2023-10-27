package model.Decorator;

public class Decorator implements ISkill{
	private ISkill skill;
	
	public Decorator(ISkill skill) {
		this.skill = skill;
	}

	@Override
	public int operation() {
		this.skill.operation();
		return 0;
	}

}
