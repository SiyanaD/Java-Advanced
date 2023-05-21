package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,String> phoneNumber = new HashMap<>();
        while (!input.equals("search")){
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];
            phoneNumber.putIfAbsent(name,number);
            input=scanner.nextLine();
        }
        input=scanner.nextLine();
        while (!input.equals("stop")){
            if (phoneNumber.containsKey(input)){
                String value = phoneNumber.get(input);
                System.out.printf("%s -> %s%n",input,value);
            }
            else {
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input=scanner.nextLine();
        }
    }

    }

