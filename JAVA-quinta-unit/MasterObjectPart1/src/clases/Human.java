package clases;

public class Human {
	
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	protected int health = 100;
	
	public Human() {};
	
	public Integer attackHuman(Human objetivo) {
		objetivo.health -= this.strength;
		return objetivo.health;
	}
	
	
}
