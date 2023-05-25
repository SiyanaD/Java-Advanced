package FunctionalProgrammingLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class P05FilterByAge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Integer>  mapNameAndAge = new LinkedHashMap<>();


        for (int i = 0; i <n ; i++) {
            String [] linePairs = scanner.nextLine().split(",\\s+");
            String name = linePairs[0];
            int personAge = Integer.parseInt(linePairs[1]);
            mapNameAndAge.put(name,personAge);
        }
        String condition = scanner.nextLine();
        int ageLimit =Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        //филтрира според възрастов лимит
        BiPredicate<Integer,Integer> filterPredicate;
        if (condition.equals("younger")){
            filterPredicate=(personAge,age)->personAge<=age;
        } else{
            filterPredicate=(personAge,age)->personAge>=age;
        }
        //принтира според шаблона
        //Consumer
        Consumer<Map.Entry<String,Integer>> printConsumer;
        if (format.equals("age")){
            printConsumer=person-> System.out.println(person.getValue());
        } else if (format.equals("name")) {
            printConsumer=person-> System.out.println(person.getKey());
        }
        else {
            printConsumer=person-> System.out.printf("%s - %d%n",person.getKey(),person.getValue());
        }
        mapNameAndAge.entrySet().stream().filter(person->filterPredicate.test(person.getValue(),ageLimit)).forEach(printConsumer);

    }
}
