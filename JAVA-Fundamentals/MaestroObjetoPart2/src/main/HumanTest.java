package main;

import clases.Human;
import clases.Ninja;
import clases.Samurai;
import clases.Wizard;

public class HumanTest {

	public static void main(String[] args) {
		
		Human jorge = new Human("jorge");
		Ninja shenglong = new Ninja("shenglong");
		Wizard gandalf = new Wizard("gandalf");
		Samurai mushu = new Samurai("mushu");
		
		shenglong.steal(gandalf);
		System.out.println("la vida de " + gandalf.getName() + " ahora es de: " + gandalf.getHealth());
		
		gandalf.fireBall(shenglong);
		System.out.println(shenglong.getName() + " ha perdido vida, ahora tiene " + shenglong.getHealth() + " de vida");
		
		System.out.println("PERO ESPERA, UN SAMURAI A ENTRADO A LA ARENA");
		mushu.deathBlow(gandalf, "gandalf");
		mushu.deathBlow(gandalf, "shenglong");
		
	}
}
