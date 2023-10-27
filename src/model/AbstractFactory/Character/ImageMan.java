package model.AbstractFactory.Character;

import model.AbstractFactory.Image;

public class ImageMan implements Image{
	private static final ImageMan INSTANCE = new ImageMan();
	public static ImageMan getInstance() {
		return INSTANCE;
	}
	@Override
	public String getImage() {
		return "./Pictures/Man";
	}
}
