package model.Flyweight;

import java.util.HashMap;


public class MovingBullet {

	private float x,y;
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
		return "assets/"+type+".png";
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
