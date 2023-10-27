package model.AbstractFactory.Enemys;

import model.AbstractFactory.AbstractCharacter;
import model.AbstractFactory.Image;
import model.AbstractFactory.Weapon;

public class Enemy implements AbstractCharacter{

	@Override
	public Image createImage() {
		return ImageEnemy.getInstance();
	}

	@Override
	public Weapon createWeapon() {
		return WeaponEnemy.getInstance();
	}

}
