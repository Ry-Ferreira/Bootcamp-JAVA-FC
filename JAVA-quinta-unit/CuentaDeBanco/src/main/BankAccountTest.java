package main;

import clases.BankAccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CREO CUENTA DE BANCO
		BankAccount hola = new BankAccount();
		
		//OBTERNGO NUMERO DE CUENTA
		String cuenta = hola.getNumCuenta();
		System.out.println(cuenta);
		
		//DEPOSITO EN CUENTA CORRIENTE
		hola.depositarCorriente(1000);
		hola.depositarCorriente(2000);
		
		System.out.println("En cuenta corriente hay un total de: " + hola.getFondosCorriente());
		
		//DEPOSITO EN CUENTA AHORRO
		hola.depositarAhorro(10000.0);
		System.out.println("En cuenta de ahorro hay un total de" + hola.getFondosAhorro());
		
		//OBTENGO EL MONTO TOTAL CORRIENTE + AHORRO
		hola.dineroTotal();
		
		hola.retirarDinero("corriente", 3001);
		hola.retirarDinero("ahorro", 10001);
		
		
		
		//hola.depositarAhorro(42.0);
		//System.out.println(plata);
		
		
		
	}

}
