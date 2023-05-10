package stacksAndQueuesLab;

import java.util.ArrayDeque;

public class examplesMain {
    public static void main(String[] args) {
        String input = "13 42 69 73";

        ArrayDeque<Integer> stack = new ArrayDeque<>(); //последния добавен елемент

        stack.push(13);// Adds element to the top of the stack
        stack.peek();//returns the top element without removing it
        stack.pop();//returns the top element and removes it

        ArrayDeque<Integer> queue = new ArrayDeque<>();// първия добавен елемент
        queue.offer(13);//Adds element to the end of the queue
        queue.peek();//returns the front element in the queue without removing it
        queue.poll();//returns the front element in the queue and removes it

        //тернален оператор->
                             // ?- ако
                            //: - или

        // String output = queue.isEmpty() ? "Printer is on standby":"Canceled"+queue.poll();

        // reads stack from the console:
        //Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt)
        //        .forEach(n->stack.push(n));

        //for (Integer integer : stack) {
           // System.out.println(integer);

        //}

        //PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();  подрежда числата по големина


    }
}
