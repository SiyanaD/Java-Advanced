package stacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class basicStackOperations02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String [] line = scanner.nextLine().split("\\s+");

        int pushElements = Integer.parseInt(line[0]);
        int popElements = Integer.parseInt(line[1]);
        int checkElements = Integer.parseInt(line[2]);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                limit(pushElements). // limit() - ограничава броя на елементите
                forEach(s->stack.push(s));

        for (int i = 0; i < popElements; i++) {
            stack.pop();

        }
        if (stack.contains(checkElements)){
            System.out.println("true");
        }
        else if (stack.isEmpty()) {
            System.out.println(0);

        }
        else {
         int minNumber = Collections.min(stack);// find a min number in to a Stack

            System.out.println(minNumber);
        }





    }
}
