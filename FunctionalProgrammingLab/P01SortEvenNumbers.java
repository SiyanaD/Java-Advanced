package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+")).
                map(e->Integer.parseInt(e)).filter(x->x%2==0).collect(Collectors.toList());


        extracted(numbers);

        System.out.println();

        //stream().sorted() - сортира числата по възходящ ред

       List<Integer>sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());

       extracted(sortedNumbers);



}

    private static void extracted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() ; i++) {//по този начин махаме запетайката отзад на реда
            if (numbers.size()-1>i){
                System.out.print(numbers.get(i)+ ", ");
            }
            else {

            System.out.print(numbers.get(i));
        }

    }
    }
}
