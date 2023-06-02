package DefiningClassesExercises.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Engine> listEngine = new ArrayList<>();//списък с двигателите


        for (int linesOfEngines = 0; linesOfEngines <n; linesOfEngines++) {
            //"{Model} {Power}
            //{Displacement} {Efficiency}" - optional
            String [] engineLine = scanner.nextLine().split("\\s+");

            String modelEngine = engineLine[0];
            int enginePower = Integer.parseInt(engineLine[1]);

            //optional
            int displacement = 0;
            String efficiency = null;

            //проверка дали са ми въведени displacement и efficiency
            if (engineLine.length==4){//"{Model} {Power} {Displacement} {Efficiency}"
                displacement = Integer.parseInt(engineLine[2]);
                efficiency=engineLine[3];
            }
            else if (engineLine.length==3){
                //["model", "power", "displacement"] -> ["model", "432", "54"]
                //["model", "power", "efficiency"] -> ["model", "432", "b"]
                if (Character.isDigit(engineLine[2].charAt(0))){ //displacement
                    displacement = Integer.parseInt(engineLine[2]);
                }
                else {
                    efficiency=engineLine[2];
                }
            }
            //model, power, displacement, efficiency
            Engine engine = new Engine(modelEngine,enginePower,displacement,efficiency);
            //добавям двигателя в списъка
            listEngine.add(engine);

        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int numberOfCars = 1; numberOfCars <= m; numberOfCars++) {

            //"{Model} {Engine} {Weight} {Color} where the engine in the format will be the
            //model of an existing Engine
            String [] carLine = scanner.nextLine().split("\\s+");
            String carModel = carLine[0];
            String engineModel = carLine[1];

            //A Car's weight, color - optional
            int weight = 0;
            String color = null;
            //проверка какво ни е въведено
            if (carLine.length==4){  //"{Model} {Engine} {Weight} {Color}
                weight = Integer.parseInt(carLine[2]);
                color = carLine[3];
            }
            else if (carLine.length==3) {
                //2. ["{Model}", "{Engine Model}", "5464"]
                //3. ["{Model}", "{Engine Model}", "red"]
                if (Character.isDigit(carLine[2].charAt(0))){
                    weight = Integer.parseInt(carLine[2]);
                }
                else {
                    color = carLine[2];
                }

            }

            //When creating the object for a Car, you should keep a reference to the real engine in
            //it, instead of just the engine's model,
            //намеря кой е двигателя от въведените
            //списък с налични двигатели -> намеря двигателя

            Engine carEngine = null;//двигателя на колата
            for (Engine engineCar : listEngine) {
                if (engineModel.equals(engineCar.getModel())){
                    carEngine=engineCar;
                    break;
                }
                
            }
            

        //Your task is to print each car (in the order you received them) and its information in the format defined below. If
        //any of the optional fields have not been given,print "n/a" in its place instead of:

        Car car = new Car(carModel,carEngine,weight,color);
            System.out.print(car.toString());
        }
    }
}
