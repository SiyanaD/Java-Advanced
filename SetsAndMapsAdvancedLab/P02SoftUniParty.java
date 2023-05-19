package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Set<String> guests = new TreeSet<>();//TreeSet<>()- подрежда данните спрямо ACI таблицата,първо са цифрите и след това са буквите

        while (!data.equals("PARTY")){
            guests.add(data);
            data=scanner.nextLine();
        }
        data=scanner.nextLine();
        while (!data.equals("END")){
            guests.remove(data);

            data=scanner.nextLine();
        }
        System.out.println(guests.size());
        for (String guestDidNotCome : guests) {
            System.out.println(guestDidNotCome);

        }


    }
}
