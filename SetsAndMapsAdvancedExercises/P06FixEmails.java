package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,String> map= new LinkedHashMap<>();

        while (!input.equals("stop")){

            String email = scanner.nextLine();

            if (!(email.contains(".us") || email.contains(".uk") || email.contains(".com"))){
                map.put(input,email);
            }
            input=scanner.nextLine();
        }
        map.forEach((k,v)-> System.out.printf("%s -> %s%n",k,v));
    }
}
