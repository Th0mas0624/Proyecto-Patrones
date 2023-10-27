package model.AbstractFactory.Character;

import model.AbstractFactory.Image;

public class ImageGirl implements Image{
	private static final ImageGirl INSTANCE = new ImageGirl();
	public static ImageGirl getInstance() {
		return INSTANCE;
	}
	@Override
	public String getImage() {
		return "./Pictures/Girl";
	}
}
