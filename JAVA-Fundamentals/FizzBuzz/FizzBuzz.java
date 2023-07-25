public class FizzBuzz {

    public String fizzBuzz(int numero){

        if(numero % 15 == 0){
            return "FizzBuzz";
        } else if(numero % 5 == 0){
            return "Buzz";
        } else if (numero % 3 == 0){
            return "Fizz";
        } else if ( numero % 2 == 0){
            return "2";
        }

        return String.valueOf(numero);

    }
}