package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names= Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        //Consumer<String> printConsumer = a1 -> System.out.println(a1);

        Consumer<String> print=p-> System.out.println(p);
        for (String name : names) {
            print.accept(name);

        }
    }
}
