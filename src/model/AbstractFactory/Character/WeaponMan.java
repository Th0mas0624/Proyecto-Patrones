package model.AbstractFactory.Character;

import model.AbstractFactory.Weapon;

public class WeaponMan implements Weapon{

	private static final WeaponMan INSTANCE = new WeaponMan();
	public static WeaponMan getInstance() {
		return INSTANCE;
	}
	@Override
	public String getWeapon() {
		return ImageMan.getInstance().getImage()+"/imagen.png";
	}

}
