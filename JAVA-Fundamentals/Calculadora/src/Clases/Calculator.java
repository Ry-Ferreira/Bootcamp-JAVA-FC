package Clases;

import java.io.Serializable;

public class Calculator implements Serializable {

	private Double result;
	
	//CONSTRUCTOR VACIO JAVA BEANS
	public Calculator() {	
	};
	
	
	public void performOperation(double operandOne, String operation, double operandTwo) {
		
		
		if(operation == "+"){
			double suma = operandOne + operandTwo;
			setResult(suma);
			System.out.println(getResult());
		}
		
		else if(operation == "-"){
			double resta = operandOne - operandTwo;
			setResult(resta);
			System.out.println(getResult());
		}
		
		else if(operation == "/") {
			
				if(operandTwo != 0) {
					double division = operandOne/operandTwo;
					setResult(division);
					System.out.println(getResult());
				} else {
					System.out.println("No se puede divir entre 0, ingresa otro valor");
				}
			}
		
		else {
			double multiplicacion = operandOne * operandTwo;
			setResult(multiplicacion);
			System.out.println(getResult());
		}
		
		
	}

	
	//GETTERS AND SETTERS

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	
	
	
	
}
