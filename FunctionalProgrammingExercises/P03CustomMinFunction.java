package FunctionalProgrammingExercises;

import java.util.Arrays;

import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     Integer [] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
     //намираме най малкото число
        Function<Integer [], Integer> findSmallestNumber = arr->Arrays.stream(arr).mapToInt(e->e).min().getAsInt();

        Integer smallestNumber = findSmallestNumber.apply(numbers);
        System.out.println(smallestNumber);




    }
}
