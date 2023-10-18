package model.AbstractFactory.Character;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Image;
import model.AbstractFactory.Weapon;

public class Man implements AbstractCharacter{

	@Override
	public Image createImage() {
		return ImageMan.getInstance();
	}

	@Override
	public Weapon createWeapon() {
		return WeaponMan.getInstance();
	}

}
