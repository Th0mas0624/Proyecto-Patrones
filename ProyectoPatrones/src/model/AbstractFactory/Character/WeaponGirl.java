package model.AbstractFactory.Character;

import model.AbstractFactory.Weapon;

public class WeaponGirl implements Weapon{

	private static final WeaponGirl INSTANCE = new WeaponGirl();
	public static WeaponGirl getInstance() {
		return INSTANCE;
	}
	@Override
	public String getWeapon() {
		return "Ruta";
	}

}
