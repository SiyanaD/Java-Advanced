package ExampleJavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01TempleOfDoom17June2023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tools = scanner.nextLine();
        String substances = scanner.nextLine();

        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();

        ArrayDeque<Integer> substancesStack = new ArrayDeque<>();

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+")).
                map(Integer::parseInt).collect(Collectors.toList());

        Arrays.stream(tools.split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(t->toolsQueue.offer(t));

        Arrays.stream(substances.split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(s->substancesStack.push(s));

        int values = 0;

        while (!toolsQueue.isEmpty()&&!substancesStack.isEmpty()) {

            int tool = toolsQueue.peek();
            int substance = substancesStack.peek();
            values = tool * substance;

            if (integers.contains(values)){
                    toolsQueue.poll();
                    substancesStack.pop();
                    integers.remove(Integer.valueOf(values));
            }
                else {
                    //o	Increase the value of the tool element by 1
                    // and move the element to the back of the tools’ sequence
                    toolsQueue.offer(toolsQueue.poll()+1);


                    //o	Decrease the value of the substance element by 1 and return the element to the substance’s sequence.
                    // If the value of the substance element reaches 0, remove it from the sequence.
                    int result =  substancesStack.pop()-1;
                    if (result>0){
                        substancesStack.push(result);
                    }
                }


        if (toolsQueue.isEmpty()&&integers.size()>0){
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");

        } else if (substancesStack.isEmpty() && integers.size()>0) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");

        }
        else if (integers.size()==0){
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");

        }
        }


        if (!toolsQueue.isEmpty()){
            System.out.print("Tools: ");
            String result = toolsQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.print(result);
            System.out.println();
        }
        else if (!substancesStack.isEmpty()) {
            System.out.print("Substances: ");
            String result = substancesStack.toString().replaceAll("[\\[\\]]", "");
            System.out.print(result);
            System.out.println();
        }



            System.out.print("Challenges: ");

            String result = integers.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.print(result);
            System.out.println();



    }
}
