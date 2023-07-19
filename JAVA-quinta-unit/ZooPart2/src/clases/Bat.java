package clases;

public class Bat extends Energy{
	
	public void fly() {
		this.setEnergia(this.getEnergia() - 50);
		System.out.println("JJGGUUIIIHHHHHH!!!!!, el murcielago ha empezado a volar y ha perdido energia, su nivel de energia es " + this.displayEnergy());
	}
	
	public void eatHumans() {
		this.setEnergia(this.getEnergia() + 25);
		System.out.println("ÑAM ÑAM!!!!!, bueno, no importa. Lo ha hecho de nuevo y su nivel de energia es " + this.displayEnergy());
	}
	
	public void attackTown() {
		this.setEnergia(this.getEnergia() - 100);
		System.out.println("<ciudad en llamas> AAHHHHH!!! SOCORROO, El muercielago ha atacado e incendiado la ciudad, DE NUEVOO!!!. Su energía actual es " + this.displayEnergy());	
	}
}
