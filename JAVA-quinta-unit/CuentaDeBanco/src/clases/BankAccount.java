package clases;

import java.util.Random;

public class BankAccount {
	
	private String numCuenta;
	private Double saldoCorriente;
	private Double saldoAhorro;
	
	private static int cuentas = 0;
	private static int fondosCorriente = 0;
	private static int fondosAhorro = 0;
	private static int fondosTotales = 0;
	
	
	//NUMERO DE CUENTA
	private String idCuenta(){
		
		// LIMITE DE 10 DIGITOS
		int leftLimit = 0000000000;
	    int rightLimit = 1000000000;
	    int generatedLong = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		// CONVIRTIENDO EL VALOR EN POSITIVO
		generatedLong = Math.abs(generatedLong);

		//generatedLong = (int) (generatedLong % 10000000000L);
		String numberStr = String.valueOf(generatedLong);
		return numberStr = setNumCuenta(numberStr); 
	};

	
	public Double depositarCorriente(double cantidad) {
		this.saldoCorriente = cantidad;
		this.fondosCorriente += saldoCorriente;
		System.out.println("Cuenta Corriente - se deposito: " + saldoCorriente);
		return (double) fondosCorriente;
		
	}
	
	public Double depositarAhorro(double cantidad) {
		this.saldoAhorro = cantidad;
		this.fondosAhorro += saldoAhorro;
		System.out.println("Cuenta Ahorro - se deposito: " + saldoAhorro);
		return (double) fondosAhorro;
	}
	
	public void dineroTotal() {
		this.fondosTotales = fondosAhorro + fondosCorriente;
		System.out.println(fondosTotales);
	};
	
	
	public void retirarDinero(String cuenta, int cantidad){
	
		//CUENTA CORRIENTE
		if(cuenta == "corriente" && fondosCorriente >= cantidad) {
			this.fondosCorriente -= cantidad;
			System.out.println("Transaccion exitosa" + " " + "Tu saldo actual en cuenta corriente es de: " + getFondosCorriente());
		} else {
			System.out.println("Saldo insuficiente" + " " + "Su saldo actual en cuenta corriente es de: " + getFondosCorriente());
		}
		
		//CUENTA AHORRO
		
		if(cuenta == "ahorro" && fondosAhorro >= cantidad) {
			this.fondosAhorro -= cantidad;
			System.out.println("Transaccion exitosa" + " " + "Tu saldo actual en cuenta de ahorro es de: " + getFondosAhorro());
		} else {
			System.out.println("Saldo insuficiente" + " " + "Su saldo actual en cuenta de ahorro es de: " + getFondosAhorro());
		}
		
	};

	//CONSTRUCTOR
	
	public BankAccount() {
		this.idCuenta();
		BankAccount.cuentas++;
	}
	
	
	
	
	
	//GETTERS AND SETTERS
	public String getNumCuenta() {
		return numCuenta;
	}


	public String setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
		return numCuenta;
	}


	public Double getSaldoCorriente() {
		return saldoCorriente;
	}


	public void setSaldoCorriente(Double saldoCorriente) {
		this.saldoCorriente = saldoCorriente;
	}


	public Double getSaldoAhorro() {
		return saldoAhorro;
	}


	public void setSaldoAhorro(Double saldoAhorro) {
		this.saldoAhorro = saldoAhorro;
	}


	public static int getCuentas() {
		return cuentas;
	}


	public static void setCuentas(int cuentas) {
		BankAccount.cuentas = cuentas;
	}


	public static int getFondosCorriente() {
		return fondosCorriente;
	}


	public static void setFondosCorriente(int fondosCorriente) {
		BankAccount.fondosCorriente = fondosCorriente;
	}


	public static int getFondosAhorro() {
		return fondosAhorro;
	}


	public static void setFondosAhorro(int fondosAhorro) {
		BankAccount.fondosAhorro = fondosAhorro;
	}


	public static int getFondostotales() {
		return fondosTotales;
	}


	public static void setFondostotales(int fondostotales) {
		BankAccount.fondosTotales = fondostotales;
	};
	
	
	
	
	
	
	
}
