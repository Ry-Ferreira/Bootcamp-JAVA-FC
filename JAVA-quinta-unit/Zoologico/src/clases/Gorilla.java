package clases;

public class Gorilla extends Mammal{
	
	public void trowSomething() {
		this.setEnergia(this.getEnergia() - 5);
		System.out.println("El gorilla ha lanzado algo, y su energía a disminuido a " + this.displayEnergy());
	}
	
	public void eatBananas() {
		this.setEnergia(this.getEnergia() + 10);
		System.out.println("El gorilla ha comido una banana, esta satisfecho y su energía ha sido incrementado a " + this.displayEnergy());
	}
	
	public void climb() {
		this.setEnergia(this.getEnergia() - 10);
		System.out.println("El gorilla ha trepado a la sima de un arbol, y su energía a disminuido a " + this.displayEnergy());
	}
}
