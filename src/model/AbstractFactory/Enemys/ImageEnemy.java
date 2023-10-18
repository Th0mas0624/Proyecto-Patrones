package model.AbstractFactory.Enemys;

import model.AbstractFactory.Image;

public class ImageEnemy implements Image{
	private static final ImageEnemy INSTANCE = new ImageEnemy();
	public static ImageEnemy getInstance() {
		return INSTANCE;
	}
	@Override
	public String getImage() {
		return "Ruta";
	}
}
