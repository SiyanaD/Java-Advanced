package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                                       .collect(Collectors.toList());
//    List<String> lengthNames=names.stream().filter(z->z.length()==n).collect(Collectors.toList());
//
//
//        lengthNames.forEach(a-> System.out.println(a));
        Predicate<String> wordLength = w->w.length()<=n;
        names.stream().filter(wordLength).forEach(f-> System.out.println(f));


    }
}
