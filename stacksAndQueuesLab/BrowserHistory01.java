package stacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String currentURL=null;

        ArrayDeque<String> stack = new ArrayDeque<>();


        while (!input.equals("Home")){

            if (input.equals("back")) {

                if (stack.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                else {
                   currentURL= stack.pop();//изтриваш текущия URL
                }
            }
            else {
                if (currentURL!=null){ //проверка ако URL не e празен
                    stack.push(currentURL);//добавяш URL
                }
                currentURL=input;//update на текущия URL

            }
            System.out.println(currentURL);


            input=scanner.nextLine();
        }

    }

}
