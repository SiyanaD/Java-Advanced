package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  stack => LIFO => ArrayDeque (pop () , push () , peek () )
        // queue => FIFO => ArrayDeque (poll () , offer () , peek () )

        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")){
            if(!input.equals("forward")&& !input.equals("back")){
                browser.push(input);
                if (!forward.isEmpty()){
                    forward.clear();

                }
                System.out.println(input);
            }
            else if ("back".equals(input)){
                if (browser.size()>1){
                    forward.push(browser.peek());
                    browser.pop();
                    System.out.println(browser.peek());
                }


            else {
                System.out.println("no previous URLs");
            }
            }
            else if ("forward".equals(input)){
                if (!forward.isEmpty()){
                    browser.push(forward.peek());
                    System.out.println(forward.pop());
                }
                else {
                    System.out.println("no next URLs");

                }
            }

            input=scanner.nextLine();
        }

    }




    }

