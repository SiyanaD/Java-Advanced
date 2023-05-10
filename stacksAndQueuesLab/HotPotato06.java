package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // LIFO => ArrayDeque (pop () , push () , peek () ) STACK
        // FIFO => ArrayDeque (poll () , offer () , peek () ) QUEUE

     String names = scanner.nextLine();
        int numberOfPassing = Integer.parseInt(scanner.nextLine());

        ArrayDeque <String> queue=new ArrayDeque<>();

        Arrays.stream(names.split("\\s+")).forEach(n->queue.offer(n));

        while (queue.size()>1){
        for (int i = 1; i < numberOfPassing; i++) {
            queue.offer(queue.poll());// remove the current name with queue.poll()
        }
            System.out.println("Removed "+queue.poll());
        }

        System.out.println("Last is " + queue.peek());


    }
}
