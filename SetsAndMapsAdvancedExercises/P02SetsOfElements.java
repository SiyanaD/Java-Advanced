package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] numbers = scanner.nextLine().split("\\s+");
        int nNumber = Integer.parseInt(numbers[0]);
        int mNumber = Integer.parseInt(numbers[1]);

        Set<Integer> nNumberSet = new LinkedHashSet<>();
        Set<Integer> mNumberSet = new LinkedHashSet<>();

        for (int i = 0; i <nNumber ; i++) {
            String number = scanner.nextLine();
            nNumberSet.add(Integer.parseInt(number));
        }
        for (int i = 0; i <mNumber ; i++) {
            String number = scanner.nextLine();
            mNumberSet.add(Integer.parseInt(number));
        }

//        for (Integer integer : nNumberSet) {
//            for (Integer integer1 : mNumberSet) {
//                if (integer.equals(integer1)){
//                    System.out.print(integer + " ");
//
//                }
//
//            }
//
//        }
        //or comparing 2 sets with retainAll
        //retainAll-изтрива всички елемени в nNumberSet, който не се съдържат в mNumberSet

        nNumberSet.retainAll(mNumberSet);
        for (Integer integer : nNumberSet) {
            System.out.print(integer + " ");
        }



    }
}
