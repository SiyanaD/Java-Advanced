package ExampleJavaAdvancedExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        String [][] raceRouteMatrix = new String[n][n];
        int rowStartCoordinates = 0;
        int colStartCoordinates = 0;

        //попълване на матрицата
        fillTheMatrix(raceRouteMatrix,scanner);

        //намираме тунелите -> 2 тунела
        //тунел 1 -> ред, колона
        //тунел 2 -> ред, колона
        //лист с 4 елемента ->
        // 1ви елемент (ред на тунел1), 2ри елемент (колона на тунел1)
        // 3ти елемент (ред на тунел2), 4ти елемент (колона на тунел2)
        List<Integer> tunnelsCoordinate= new ArrayList<>();
        findTunnels(raceRouteMatrix,tunnelsCoordinate);
        int km = 0;

        String directions = scanner.nextLine();
        while (!directions.equals("End")){

            if (directions.equals("left")){
                colStartCoordinates--;
            } else if (directions.equals("right")) {
                colStartCoordinates++;

                
            } else if (directions.equals("up")) {
                rowStartCoordinates--;


            } else if (directions.equals("down")) {
                rowStartCoordinates++;

            }

            //rowStartCoordinates, colStartCoordinates -> къде се намира колата след преместване
            //там, където е преместена какво има?
            String movedPlace = raceRouteMatrix[rowStartCoordinates][colStartCoordinates]; //място по трасето, на което сме се преместили

            if (movedPlace.equals(".")){
                km+=10;
            }
            if (movedPlace.equals("T")){
                //стигаме до тунел -> отиваме до другия тунел
                //координатите на колата = кординатите на втория тунел
                //tunnelCoordinates -> лист с 4 елемента ->
                // 1ви елемент (ред на тунел1), 2ри елемент (колона на тунел1)
                // 3ти елемент (ред на тунел2), 4ти елемент (колона на тунел2)
                rowStartCoordinates=tunnelsCoordinate.get(2);//взимаме кооординатите на 2рия тунел
                colStartCoordinates=tunnelsCoordinate.get(3);
                km+=30;
                //заместваме тунелите с точка, защото вече сме преминали
                raceRouteMatrix[tunnelsCoordinate.get(0)][tunnelsCoordinate.get(1)]=".";//замествам първия тунел с .
                raceRouteMatrix[tunnelsCoordinate.get(2)][tunnelsCoordinate.get(3)]=".";//замествам втория тунел с .
            }
            if (movedPlace.equals("F")){
                System.out.printf("Racing car %s finished the stage!%n",racingNumber);
                km+=10;
                break;

            }

            directions=scanner.nextLine();

        }
        if (directions.equals("End")){
            System.out.printf("Racing car %s DNF.%n",racingNumber);
        }
        System.out.printf("Distance covered %d km.%n",km);
        //там където е колата да слагаме C

        raceRouteMatrix[rowStartCoordinates][colStartCoordinates]="C";

        printMatrix(raceRouteMatrix);

    }

    private static void printMatrix(String[][] raceRouteMatrix) {
        for (int row = 0; row <raceRouteMatrix.length ; row++) {
            for (int col = 0; col <raceRouteMatrix[row].length ; col++) {
                System.out.print(raceRouteMatrix[row][col]);

            }
            System.out.println();

        }
    }

    private static void findTunnels(String[][] raceRouteMatrix, List<Integer> tunnelsCoordinate) {
        for (int row = 0; row <raceRouteMatrix.length ; row++) {
            for (int col = 0; col <raceRouteMatrix[row].length ; col++) {
                String currentElement = raceRouteMatrix[row][col];
                if (currentElement.equals("T")){
                    tunnelsCoordinate.add(row);//добавяме реда на който се намира тунела
                    tunnelsCoordinate.add(col);//добавяме реда на който се намира колоната
                }
            }
        }
    }

    private static void fillTheMatrix(String[][] raceRouteMatrix, Scanner scanner) {
        for (int row = 0; row <raceRouteMatrix.length ; row++) {

            raceRouteMatrix[row]=scanner.nextLine().split("\\s+");//дава ти реда
        }
    }
}
