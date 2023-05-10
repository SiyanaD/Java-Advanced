package stacksAndQueuesLab;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackReversed = new ArrayDeque<>();

        Arrays.stream(input.split("\\s+")).forEach(s->stack.push(s));

        while (!stack.isEmpty()){// add elements from first stack "stack" in to other stack "stackReversed"

            stackReversed.push(stack.pop());
        }
        while (stackReversed.size()>1){
            int firstNum = Integer.parseInt(stackReversed.pop());
            String operation = stackReversed.pop();
            int secondNum = Integer.parseInt(stackReversed.pop());
           if ("+".equalsIgnoreCase(operation)){//equalsIgnoreCase игнорира главни и малки букви
               stackReversed.push(firstNum+secondNum+"");
           }
           else {
               stackReversed.push(firstNum-secondNum+"");
           }

        }
        System.out.println(stackReversed.peek());

    }
}
