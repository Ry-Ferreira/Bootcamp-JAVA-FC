public class TestPit {

    public static void main(String[] args){

        // Llamando al teoremaPit
        TeoremaPit calculador = new TeoremaPit();

        double resultado = calculador.calcularHipotenusa(6, 5);
        System.out.println("El resultado es : "+ resultado);
    }
};