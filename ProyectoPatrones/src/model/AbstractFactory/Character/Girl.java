package model.AbstractFactory.Character;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Image;
import model.AbstractFactory.Weapon;

public class Girl implements AbstractCharacter{

	@Override
	public Image createImage() {
		return null;
	}

	@Override
	public Weapon createWeapon() {
		return WeaponMan.getInstance();
	}

}
