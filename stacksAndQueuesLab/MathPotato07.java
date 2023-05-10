package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String names = scanner.nextLine();
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue=new ArrayDeque<>();

        Arrays.stream(names.split("\\s+")).forEach(n->queue.offer(n));

        int round = 1;


        while (queue.size()>1){

            for (int i = 1; i < number; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(round)) {

                System.out.println("Prime " + queue.peek());
            }
            else {
                System.out.println("Removed " + queue.poll());
            }
            round++;

        }
        System.out.println("Last is " + queue.peek());

    }
    private  static boolean isPrime(int round){

        if (round==1){
            return  false;
        }
        for (int i = 2; i <round ; i++) {
            if (round % i==0){
                return false;
            }

        }
        return true;
    }
}
