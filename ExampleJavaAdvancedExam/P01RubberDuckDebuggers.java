package ExampleJavaAdvancedExam;

import java.util.*;

public class P01RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> programmerQueue = new ArrayDeque<>();
        ArrayDeque<Integer> numberOfTasksStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(p->programmerQueue
                .offer(Integer.parseInt(p)));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(n->numberOfTasksStack
                .push(Integer.parseInt(n)));
        int neededTime = 0;

        //вид патка и брой
        Map<String,Integer> ducksMap = new LinkedHashMap<>();
        ducksMap.put("Darth Vader Ducky",0);
        ducksMap.put("Thor Ducky",0);
        ducksMap.put("Big Blue Rubber Ducky",0);
        ducksMap.put("Small Yellow Rubber Ducky",0);
        //Darth Vader Ducky
        //Thor Ducky
        //Big Blue Rubber Ducky
        //Small Yellow Rubber Ducky
        while (!programmerQueue.isEmpty() && !numberOfTasksStack.isEmpty()){
            int firstProgrammer = programmerQueue.peek();//първия елемент на опашката
            int firstNumberTasks = numberOfTasksStack.peek();//последния елемент в стека

            neededTime=firstProgrammer*firstNumberTasks;
            //•	If the calculated time is between any of the time ranges below,
            // you give the corresponding ducky and remove the programmer time's value
            // and the tasks' value.
            if (neededTime>=0 && neededTime<=60){
                //купуваме Darth Vader Ducky
                ducksMap.put("Darth Vader Ducky",ducksMap.get("Darth Vader Ducky")+1);
                programmerQueue.poll();//премахва първия елемент от опашката
                numberOfTasksStack.pop();//премахва последния елемент от стека
            } else if (neededTime>=61 && neededTime<=120) {
                ducksMap.put("Thor Ducky",ducksMap.get("Thor Ducky")+1);
                programmerQueue.poll();//премахва първия елемент от опашката
                numberOfTasksStack.pop();//премахва последния елемент от стека
            } else if (neededTime>=121 && neededTime<=180) {
                ducksMap.put("Big Blue Rubber Ducky",ducksMap.get("Big Blue Rubber Ducky")+1);
                programmerQueue.poll();//премахва първия елемент от опашката
                numberOfTasksStack.pop();//премахва последния елемент от стека
            } else if (neededTime>=181 && neededTime<=240) {
                ducksMap.put("Small Yellow Rubber Ducky",ducksMap.get("Small Yellow Rubber Ducky")+1);
                programmerQueue.poll();//премахва първия елемент от опашката
                numberOfTasksStack.pop();//премахва последния елемент от стека
            }
            //•	If the calculated time goes above the highest range, decrease the number
            // of the task's value by 2. Then, move the programmer time's value to the end
            // of its sequence, and continue with the next operation.
            else {
                programmerQueue.offer(programmerQueue.poll());
                numberOfTasksStack.push(numberOfTasksStack.pop()-2);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");

        //•	On the next 4 lines, you output the type and number of ducks given, ordered like in the table:
        //o	"Darth Vader Ducky: {count}
        //Thor Ducky: {count}
        //Big Blue Rubber Ducky: {count}
        //Small Yellow Rubber Ducky: {count}"
        for (Map.Entry<String,Integer> duckEntry : ducksMap.entrySet()){
            //duckEntry
            //key: вид на патката
            //value: брой на патките от този вид
            System.out.println(duckEntry.getKey() + ": "+duckEntry.getValue());
        }

    }
}
