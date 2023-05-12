package stacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class reverseNumbersWithAStack01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String numbers = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(numbers.split("\\s+")).mapToInt(Integer::parseInt).forEach(s->stack.push(s));

      while (!stack.isEmpty()){
          System.out.print(stack.pop()+ " ");
      }


    }
}
