package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int pollinatedFlowers = 0;

        char[][] matrix = new char[size][size];
        //пълнене на Char матрица
        for (int row = 0; row < matrix.length; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rowData[col];
            }
        }
        //B- The bee will be placed in a random position, marked with the letter 'B'-намираме позицията
        int beeRow = -1;
        int beeCol = -1;
        //намираме позицията на катерицата
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'B') {
                    //знаем позицията на пчелата, къде точно се намира на кой ред и колона
                    beeRow = row;
                    beeCol = col;
                }
            }
        }
        String direction = scanner.nextLine();
        while (!direction.equals("End")){

            matrix[beeRow][beeCol] = '.';//когато пчелата се мести на текущото и място слагаме '.'

            if (direction.equals("left")) {
                beeCol--;
            } else if (direction.equals("right")) {
                beeCol++;

            } else if (direction.equals("up")) {
                beeRow--;
            } else if (direction.equals("down")) {
                beeRow++;
            }
            //o	If the bee goes out of its territory print: "The bee got lost!"
            //валидираме матрицата
            if (beeRow<0||beeRow>=size||beeCol<0||beeCol>=size){
                System.out.println("The bee got lost!");
                break;
            }

            //On random positions, there will be flowers, marked with 'f'
            if (matrix[beeRow][beeCol]=='f'){
                pollinatedFlowers++;

            }

            //If it goes to a bonus, the bee gets a bonus one moves forward
            // and then the bonus disappears
            if (matrix[beeRow][beeCol]=='O'){
                continue;

            }


            ////ако са валидни реда и колоната на пчелата слагаме 'B'
            matrix[beeRow][beeCol] = 'B';
            direction=scanner.nextLine();
        }
        if (pollinatedFlowers<5){

            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-pollinatedFlowers);
        }
        else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] raceRouteMatrix) {
        for (int row = 0; row <raceRouteMatrix.length ; row++) {
            for (int col = 0; col <raceRouteMatrix[row].length ; col++) {
                System.out.print(raceRouteMatrix[row][col]);

            }
            System.out.println();

        }
    }
}
