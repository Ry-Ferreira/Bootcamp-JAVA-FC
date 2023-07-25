package Main;

import Clases.Calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator operacion = new Calculator();
		
		operacion.performOperation(10.5, "+", 5.2);
		operacion.performOperation(2, "-", 10);
		operacion.performOperation(10, "*", -2);
		operacion.performOperation(10, "/", 0);
		operacion.performOperation(10, "/", 2.5);
	}

}
