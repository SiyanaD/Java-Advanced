package DefiningClassesExercises.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int startKilometers = 0;


        Map<String,Car> map = new LinkedHashMap<>();


        for (int i = 0; i <n ; i++) {
            String [] carInformation = scanner.nextLine().split("\\s+");
            String model= carInformation[0];
            int fuelAmount = Integer.parseInt(carInformation[1]);
            double fuelCostFor1km = Double.parseDouble(carInformation[2]);

            Car car = new Car(model,fuelAmount,fuelCostFor1km);
            map.putIfAbsent(model,car);
        }
        String line = scanner.nextLine();
        while (!line.equals("End")){
            //, implement a method in the Car class to calculate whether a car can move that
            //distance or not
            String carModel = line.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(line.split("\\s+")[2]);
            //взимам коя кола ще карам
            Car carToDrive = map.get(carModel);

            //drive -> false -> горивото не ни стига, за да изминем разстоянието
            //drive -> true -> горивото е стигнало и ние сме изминали разстоянието
            if (!carToDrive.drive(amountOfKm)){
                System.out.println("Insufficient fuel for the drive");
            }

            line=scanner.nextLine();
        }
        for (Car car :map.values()) {
            //"{Model} {fuelAmount} {distanceTraveled}"
            System.out.println(car.toString());

        }
    }
}
