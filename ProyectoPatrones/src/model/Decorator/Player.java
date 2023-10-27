package model.Decorator;


import model.AbstractFactory.AbstractCharacter;
import model.Flyweight.MovingBullet;

public class Player implements ISkill{

	private AbstractCharacter c;
	public int xPosition = 0;
	public int yPosition = 0;
	private int health = 10;
	private int damage = 2;
	public MovingBullet m;
	
//	private List<Observer> observers = new ArrayList<>();
	
	// Instancia única del Singleton
    private static Player instance;
    private Player(float x, float y, AbstractCharacter c) {
		this.c = c;
        this.xPosition = (int) x;
        this.yPosition = (int) y;
    }

    public static Player getInstance(int x, int y, AbstractCharacter c) {
        if (instance == null) {
            instance = new Player(x, y, c);
        }
        instance.m = new MovingBullet(x, y);
        return instance;
    }
		
	
	@Override
	public void operation() {
		shoot();
		
	}
	
	public void shoot() {	
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
	
	public void jump(int value) {
		this.yPosition += value;
		/*for (int i = 0; i > value; i-=5) {
			this.yPosition +=5;
			try {
	            Thread.sleep(1000); // Pausa durante 1 segundo (1000 milisegundos)
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}*/
	}
	public AbstractCharacter getC() {
		return c;
	}
	
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int damage) {
		this.health -= damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
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
