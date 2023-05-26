package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .map(Integer::parseInt).collect(Collectors.toList());



        String command = scanner.nextLine();
        while (!command.equals("end")){
            if (command.equals("add")){
                Function<Integer,Integer> add = n->n+1;
            numbers= numbers.stream().map(e->add.apply(e)).collect(Collectors.toList());

            }
            else if (command.equals("multiply")) {
                Function<Integer,Integer> multiply = n->n*2;
                numbers=numbers.stream().map(m->multiply.apply(m)).collect(Collectors.toList());
            }
            else if (command.equals("subtract")) {
                Function<Integer,Integer> subtract = n->n-1;

                numbers=numbers.stream().map(s->subtract.apply(s)).collect(Collectors.toList());
            }
            else if (command.equals("print")) {//принтиране с Consumer
                Consumer<List<Integer>> print=list->list.forEach( p-> System.out.print(p + " "));//list->list.forEach-премахваме , и []
                    print.accept(numbers);
                System.out.println();

            }
            command=scanner.nextLine();
        }
    }
}
