package main;

import clases.Human;

public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human wizard = new Human();
		Human samurai = new Human();
		
		int resultado = wizard.attackHuman(samurai);
		
		System.out.println(resultado);
	}

}
