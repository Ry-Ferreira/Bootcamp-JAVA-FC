package main;

import clases.Gorilla;

public class GorillaTesting {

	public static void main(String[] args) {
		

		Gorilla kingKong = new Gorilla();
		kingKong.displayEnergy();
		
		//LANZA 3 VECES
		kingKong.trowSomething();
		kingKong.trowSomething();
		kingKong.trowSomething();

		
		// COME DOS VECES
		kingKong.eatBananas();
		kingKong.eatBananas();
		
		//TREPA UNA VEZ
		kingKong.climb();
		kingKong.displayEnergy();
		
	}

}
