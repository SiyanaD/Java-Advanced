package stacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i <parentheses.length() ; i++) {

            char openParentheses = parentheses.charAt(i);

          if (openParentheses=='{'|| openParentheses=='('|| openParentheses == '['){
              stack.push(openParentheses);
          }
          else {
              if (stack.isEmpty()){
                  isBalanced=false;
                  break;
              }

              char closeParentheses = stack.pop();

              if (closeParentheses!='{'&& parentheses.charAt(i)=='}'){
                  isBalanced=false;
                  break;
              } else if (closeParentheses!='('&&parentheses.charAt(i)==')') {
                  isBalanced=false;
                  break;

              } else if (closeParentheses!='['&&parentheses.charAt(i)==']') {
                  isBalanced=false;
                  break;

              }


          }

        }
        if (isBalanced&&stack.isEmpty()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }







    }
}
