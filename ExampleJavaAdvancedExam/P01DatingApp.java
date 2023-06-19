package ExampleJavaAdvancedExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01DatingApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //You have to start with the first female and try to match it with the last male
        ArrayDeque<Integer> mailStack = new ArrayDeque<>();
        ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(m->mailStack.push(Integer.parseInt(m)));

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(f->femalesQueue.offer(Integer.parseInt(f)));

        int successfulMatches = 0;

        while (!mailStack.isEmpty() && !femalesQueue.isEmpty()){
            int firstFemalesQueue = femalesQueue.peek();
            int lastMailStack = mailStack.peek();

            //•	If someone’s value is equal to or below 0,
            // you should remove him/her from the records before trying to match him/her with anybody
            if (firstFemalesQueue<=0){
                femalesQueue.poll();
                continue;

            }
            if (lastMailStack<=0){
                mailStack.pop();
                continue;
            }

            //•	Special case - if someone’s value
            // is divisible by 25 without remainder, you should remove him/her
            // and the next person of the same gender.
            if (firstFemalesQueue%25==0){
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (lastMailStack%25==0){
                mailStack.pop();
                mailStack.pop();
                continue;
            }
            //•	If their values are equal, you have to match them and
            // remove both of them.
            if (firstFemalesQueue==lastMailStack) {
                successfulMatches++;
                mailStack.pop();
                femalesQueue.poll();
            }
            //. Otherwise, you should remove only the female and decrease the value of the male by 2.
            else {
                femalesQueue.poll();
                int resulMail= mailStack.pop()-2;
                mailStack.push(resulMail);
            }
        }

        //•	On the first line of output - print the number of successful matches:
        //o	"Matches: {matchesCount}"
        System.out.printf("Matches: %d%n",successfulMatches);

        //•	On the second line - print all males left:
        //o	If there are no males: "Males left: none"
        if (mailStack.isEmpty()){
            System.out.println("Males left: none");
        }
        //o	If there are males: "Males left: {male1}, {male2}, {male3}, (…)"

        else {
            System.out.print("Males left: ");
            //на края на реда не слага ", "->
            String result = mailStack.toString().replaceAll("[\\[\\]]", "");
            System.out.print(result);
            System.out.println();
        }


        //•	On the third line - print all females left:
        //o	If there are no females: "Females left: none"
        if (femalesQueue.isEmpty()){
            System.out.println("Females left: none");
        }
        //o	If there are females: "Females left: {female1}, {female2}, {female3}, (…)"
        else {
            System.out.print("Females left: ");
            //на края на реда не слага ", "->
            String result = femalesQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.print(result);
            System.out.println();

        }
    }
}
