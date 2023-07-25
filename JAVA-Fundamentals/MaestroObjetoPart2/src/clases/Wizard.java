package clases;

public class Wizard extends Human {
	

	public Wizard(String name) {
		super(name);
		this.health = this.health/2;
	};
	
	public int heal(Human objetivo) {
		objetivo.health += super.intelligence;
		return objetivo.health;
	};
	
	public int fireBall(Human objetivo) {
		objetivo.health -= (super.intelligence*3);
		System.out.println("El mago ha lanzado una bola de fuego!");
		return objetivo.health;
	};
}