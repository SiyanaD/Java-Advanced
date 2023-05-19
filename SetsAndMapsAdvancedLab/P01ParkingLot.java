package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!data.equals("END")){

            String [] input = data.split(",\\s+");

        if (input[0].equals("IN")){
            parkingLot.add(input[1]);



        } else if (input[0].equals("OUT")) {
            parkingLot.remove(input[1]);
        }

        data=scanner.nextLine();
        }
        if (!parkingLot.isEmpty()){
        for (String s : parkingLot) {
            System.out.println(s);

        }}
       else {

            System.out.println("Parking Lot is Empty");

        }

    }
}
