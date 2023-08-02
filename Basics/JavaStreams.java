import java.util.*;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> squares = new ArrayList<>();

        squares = list.stream().map(num -> num*num).collect(Collectors.toList());

        System.out.println(squares);
    }
}
