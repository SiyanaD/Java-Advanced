package DefiningClassesExercises.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line <n ; line++) {
            String [] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age =Integer.parseInt(information[1]);
            Person person = new Person(name,age);
            peopleList.add(person);
        }
        //филтрирай списъка -> само хората над 30
        peopleList = peopleList.stream().filter(a->a.getAge()>30).collect(Collectors.toList());

        //сортирам списъка по име на хората
        peopleList.sort(Comparator.comparing(p->p.getName()));
        //отпечатваме списъка
        for (Person person : peopleList) {
            //име - възраст
            //обект под формата на текст
            System.out.println(person);

        }
    }
}
