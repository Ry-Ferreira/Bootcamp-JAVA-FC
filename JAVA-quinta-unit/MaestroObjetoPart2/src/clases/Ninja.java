package clases;

public class Ninja extends Human{

	public Ninja(String name) {
		super(name);
		this.stealth = this.stealth + 7;
	};
	
	public int steal(Human objetivo) {
		objetivo.health -= super.stealth;
		System.out.println("El ninja ha entrado en sigilo y ha infligido 10 de daño");
		return objetivo.health;
	};
	
	public int runAway() {
		super.health -= 10;
		System.out.println("El ninja ha escapado, su vida ha disminuido 10p.");
		return super.health;
	};
	
	
}
