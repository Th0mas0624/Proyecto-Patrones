package model.Decorator;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import model.AbstractFactory.AbstractCharacter;
import model.Flyweight.Bullet;
import model.Flyweight.MovingBullet;
import model.Observer.Observer;

public class Player implements ISkill{

	private AbstractCharacter c;
	private int xPosition = 0;
	private int yPosition = 0;
	private int health = 10;
	public Bullet b = new Bullet("ruta");
	public MovingBullet m = new MovingBullet(xPosition, yPosition, b);
	
//	private List<Observer> observers = new ArrayList<>();

	public Player(AbstractCharacter c) {
		this.c = c;
		c.createImage();
	}
	@Override
	public void operation() {
		shoot();
		jump();
		moveRight();
		moveLeft();
	}
	
	public void shoot() {
		c.createWeapon().getWeapon();
		m.move(xPosition, yPosition);      
		//draw()
	}
	public void jump() {
		this.yPosition += 5;
	}
	public void moveRight() {
		this.xPosition += 2;
	}
	public void moveLeft() {
		this.xPosition -= 2;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int damage) {
		this.health -= damage;
	}

	/*public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.updatePlayer(this);
            observer.updatePlayerHealth(health);
        }
    }*/
}
