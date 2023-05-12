package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class maximumElement03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int nCommand = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nCommand ; i++) {

            String [] type = scanner.nextLine().split("\\s+");

            if (type[0].equals("1")){
                stack.push(Integer.parseInt(type[1]));
            }
            else if (type[0].equals("2")) {
                stack.pop();

            }


            else if (type[0].equals("3")) {

                int maxElement = Collections.max(stack);//find max number in a stack
                System.out.println(maxElement);

            }

        }



    }
}
