package clases;

public class Human {
	
	protected int strength = 3;
	protected int intelligence = 3;
	protected int stealth = 3;
	protected int health = 100;
	protected String name;
	
	public Human(String name) {
		this.name = name;
	};
	
	public Human(int strength, int intelligence, int stealth, int health, String name) {
		this.strength = strength;
		this.intelligence = intelligence;
		this.stealth = stealth;
		this.health = health;
		this.name = name;
	}
	
	public void attackHuman(Human objetivo) {
		objetivo.health -= this.strength;
	}

	
	// GETTERS AND SETTERS
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
