package stacksAndQueuesLab;

import java.util.*;

public class MathPotato07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] names = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> queue = new PriorityQueue<>();
        Collections.addAll(queue,names);

        int currentName = 1;
        while (queue.size()>1){

            for (int i = 1; i <number; i++) {
                String kids = queue.poll();
                queue.offer(kids);

            }
            if (isPrime(currentName)){
                System.out.println("Prime "+queue.peek());
            }
            else {
                String removeKid = queue.poll();
                System.out.println("Removed " + removeKid);
            }
            currentName++;
        }
        System.out.println("Last is " + queue.poll());






    }
    private static boolean isPrime(int num){
        if (num==1){
            return false;
        }
        for (int i = 2; i <num ; i++) {
            if (num%i==0){
                return false;
            }

        }
        return true;
    }
}
