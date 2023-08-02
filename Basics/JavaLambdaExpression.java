

// Interface with only one abstract method is called Single Abstract Method (SAM)
// It is also called Functional Interface
// From java 8 - if it is a functional interface then Lambda expressions can be used

interface LambdaExample{
    int speed = 100;
    int add(int a, int b); // abstract method
    default void drive(){
        System.out.println("Driving");
    }
}


@FunctionalInterface
interface StringReverser{
    String reverse(String str);
}

@FunctionalInterface
interface Adder{
    double add(int a, int b);
}

public class JavaLambdaExpression {

    public static void main(String[] args) {
        StringReverser sr = (str) -> {
            String rev = "";
            for (int i = str.length()-1; i >= 0 ; i--) {
                rev += str.charAt(i);
            }
            return rev;
        };

        System.out.println(sr.reverse("Hellooo"));


        Adder adder = (a,b) -> a+b;

        System.out.println(adder.add(10, 39));
    }
}
