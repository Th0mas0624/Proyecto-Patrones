package model.AbstractFactory.Enemys;

import model.AbstractFactory.Weapon;

public class WeaponEnemy implements Weapon{

	private static final WeaponEnemy INSTANCE = new WeaponEnemy();
	public static WeaponEnemy getInstance() {
		return INSTANCE;
	}
	@Override
	public String getWeapon() {
		return "Ruta";
	}

}
