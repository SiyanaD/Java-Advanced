package SetsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> setOfName = new TreeSet<>();

        for (int i = 0; i <n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            //Arrays.asList(input)-имплементираме в Лист и повтарящите данни се презаписват
            setOfName.addAll(Arrays.asList(input));
        }
        for (String s : setOfName) {
            System.out.print(s + " ");

        }
    }
}
