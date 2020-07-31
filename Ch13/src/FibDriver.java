import java.math.BigInteger;

public class FibDriver {
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci(15); // only needed for overload
       System.out.println(test.fibForLoop()); // slow version in text   
       System.out.println(test.fibonacci()); // slow version in text 
       System.out.println(test.bigFib()); // same as above, but use BigIntegers
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
    }
}