package model.entitys;

import helps.Constans;
import model.AbstractFactory.AbstractCharacter;
import model.Decorator.ISkill;
import model.Flyweight.Bullet;
import model.Flyweight.MovingBullet;

public class Player implements ISkill {

	private AbstractCharacter c;
	public int xPosition = 0;
	public int yPosition = 0;
	private int health = 10;
	public Bullet b = new Bullet("assets/bullet.png");
	public MovingBullet m;
	
//	private List<Observer> observers = new ArrayList<>();
	
	// Instancia única del Singleton
    private static Player instance;

    private Player(float x, float y) {
        this.xPosition = (int) x;
        this.yPosition = (int) y;
    }

    public static Player getInstance(float x, float y) {
        if (instance == null) {
            instance = new Player(x, y);
        }
		instance.m = new MovingBullet(x, y);
        return instance;
    }
	
	
	
	@Override
	public void operation() {
		shoot();
		jump();
		moveRight();
		moveLeft();
	}
	public void gravity(){
		if (yPosition < Constans.FIRST_FLOOR-3){
			yPosition +=(int)1;
		} else if (yPosition < Constans.SECOND_FLOOR && yPosition>Constans.FIRST_FLOOR) {
			yPosition +=(int)1;
		}else if (yPosition < Constans.THIRD_FLOOR && yPosition>Constans.SECOND_FLOOR) {
			yPosition +=(int)1;
		}else if (yPosition < Constans.FOUR_FLOOR && yPosition>Constans.THIRD_FLOOR) {
			yPosition +=(int)1;
		}


	}
	public void shoot() {
		c.createWeapon().getWeapon();
		m.move();      
		//draw()
	}
	public void changeXDelta(int value) {
		this.xPosition += value;
	}
	public void changeYDelta(int value) {
		this.yPosition += value;
	}
	public void setRectPos(int x, int y) {
		this.xPosition = x;
		this.yPosition = y;
	}
	
	public AbstractCharacter getC() {
		return c;
	}
	public void setC(AbstractCharacter c){
		this.c = c;
	}
	public void jump() {
		this.yPosition -= 100;
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
