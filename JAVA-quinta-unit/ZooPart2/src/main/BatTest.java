package main;

import clases.Bat;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bat chupaCabras = new Bat();
		
		// ATACA A LA CIUDAD 3 VECES
		chupaCabras.attackTown();
		chupaCabras.attackTown();
		chupaCabras.attackTown();
		
		// COME DOS HUMANOS
		chupaCabras.eatHumans();
		chupaCabras.eatHumans();
		
		// EMPIEZA A VOLAR POR PRIMERA VEZ
		chupaCabras.fly();
	}

}
