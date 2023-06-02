package DefiningClassesLab.P01CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        for (int number = 0; number <count ; number++) {
            String [] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int hp = Integer.parseInt(data[2]);

            Car car = new Car(); //нов празен обект
            car.setBrand(brand);
            car.setModel(model);
            car.setHP(hp);

            System.out.println(car);
        }

    }


}
