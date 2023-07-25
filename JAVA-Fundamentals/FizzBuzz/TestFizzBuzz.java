public class TestFizzBuzz{

    public static void main(String[] args){

        FizzBuzz resultado = new FizzBuzz();

        String result = resultado.fizzBuzz(10);

        System.out.println("El resultado es: " + resultado.fizzBuzz(15));

        for(int i=0; i<100; i++){
            result = resultado.fizzBuzz(i);
            String salida = String.format(" Numero: %d - Resultado: %s ", i, result);
            System.out.println(salida);
        }
    }
}