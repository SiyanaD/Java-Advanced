package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!input.equals("print")){
            if (input.equals("cancel")){

                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                }
                else {

                System.out.println("Canceled " + queue.poll() );
                }

                input=scanner.nextLine();
                continue;}
            else {
                queue.offer(input);
            }
            input=scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);

        }

        }
    }

