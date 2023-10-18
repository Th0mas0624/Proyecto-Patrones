package model.Flyweight;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class MovingBullet {

	private int x,y;
	private Bullet state;
	private HashMap<Integer, Bullet> bullets = new HashMap<>();
	
	
	public MovingBullet(int x, int y,Bullet state) {
		this.state = state;
		this.x = x;
		this.y = y;
	}
	
	public Bullet getBullet(int type) {
		if (!bullets.containsKey(type)) {
            bullets.put(type, new Bullet(uploadImage(type)));
        }
        return bullets.get(type);
	}
	
	public String uploadImage(int type) {
		return "Bala_"+type+".png";
	}
	public void move(int x,int y) {
		this.x += x;
		this.y += y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
	
}
