package stacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class basicQueueOperations04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String [] input = scanner.nextLine().split("\\s+");
        int enqueueElement = Integer.parseInt(input[0]);
        int dequeueElement = Integer.parseInt(input[1]);
        int checkElement = Integer.parseInt(input[2]);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).
                limit(enqueueElement).
                forEach(s->queue.offer(s));


        for (int i = 0; i <dequeueElement ; i++) {
            queue.poll();

        }

            if (queue.contains(checkElement)){
                System.out.println("true");

            } else if (queue.isEmpty()) {
                System.out.println(0);

            } else {
                int minNumber = Collections.min(queue);
                System.out.println(minNumber);

            }




    }

}
