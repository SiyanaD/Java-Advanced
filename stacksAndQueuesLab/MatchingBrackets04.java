package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch=input.charAt(i);
            if (ch=='('){
                stack.push(i);
            } else if (ch==')') {
                int indexInBrackets = stack.pop();

                System.out.println(input.substring(indexInBrackets,i+1));
            }

        }
    }
}
