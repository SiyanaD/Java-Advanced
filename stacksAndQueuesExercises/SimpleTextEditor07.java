package stacksAndQueuesExercises;


import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder emptyTex = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            if (input[0].equals("1")){
                //appends [string] to the end of the text
                stack.push(emptyTex.toString());//преди модификация съхраняваме текущотот състояние на текста
                emptyTex.append(input[1]);
            }
            else if (input[0].equals("2")) {
                stack.push(emptyTex.toString());//преди модификация съхраняваме текущотот състояние на текста
                // erases the last [count] elements from the text.
                int count = Integer.parseInt(input[1]);
                int startIndex = emptyTex.length()-count;
                int endIndex = startIndex+count;
                emptyTex.delete(startIndex,endIndex);

            }
            else if (input[0].equals("3")) {

                //returns the element at position [index] from the text.

                char result = emptyTex.charAt(Integer.parseInt(input[1])-1);

                System.out.println(result);


            }
            else if (input[0].equals("4")) {
                //undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation

               if (!stack.isEmpty()){
                   //винаги когато имаме pop пишем проверката:!stack.isEmpty()

                 String lastBeforeOperation = stack.pop();

                 emptyTex=new StringBuilder(lastBeforeOperation);

               }

            }


        }




    }
}
