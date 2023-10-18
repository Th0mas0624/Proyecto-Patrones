package model.Flyweight;

public class Bullet {

	private String imagen;
	private int damage;
	public Bullet(String imagen) {
		this.imagen = imagen;
	}
	
	public String getImagen() {
		return imagen;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
}
