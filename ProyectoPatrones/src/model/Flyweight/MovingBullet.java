package model.Flyweight;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class MovingBullet {

	private float x,y;
	private Bullet state;
	private HashMap<String, Bullet> bullets = new HashMap<>();
	
	
	public MovingBullet(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	public Bullet getBullet(String type) {
		if (!bullets.containsKey(type)) {
            bullets.put(type, new Bullet(uploadImage(type)));
        }
        return bullets.get(type);
	}
	
	public String uploadImage(String type) {
		return "Pictures/Bullets/"+type+".png";
	}
	public void move() {
		this.x += 10;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	
	
	
}
