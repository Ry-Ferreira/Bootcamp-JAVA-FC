package clases;

public class Samurai extends Human{

	private int asesinatos = 0;
	
	
	
	public Samurai(String name) {
		super(name);
		this.health = this.health*2;
	};
	
	
	public int deathBlow(Human objetivo, String name) {
		objetivo.health -= objetivo.health;
		super.health /= 2;
		
		this.name = name;
		
		if(objetivo.health == 0){
			this.asesinatos++;
		}
		System.out.println("El samurai ha lanzado su definitiva y ha matado a " + name);
		System.out.println("El samurai lleva " + this.asesinatos + " asesinatos");
		
		return objetivo.health;
		
	};
	
	public int meditate() {
		super.health += (super.health/2);
		return super.health;
	};
	
	public void howMany() {
		System.out.println("El samurai lleva " + this.asesinatos + " asesinatos");
	};
}
