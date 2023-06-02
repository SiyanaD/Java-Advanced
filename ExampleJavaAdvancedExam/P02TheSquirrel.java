package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hazelnuts = 0;//goal is 3
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        boolean isTrap = false;

        String[] directions = scanner.nextLine().split(",\\s+");
        //пълнене на Char матрица
        for (int row = 0; row < matrix.length; row++) {
            char[] rowData = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rowData[col];
            }
        }
        //s- represents the squirrel's position-намираме позицията
        int squirrelRow = -1;
        int squirrelCol = -1;
        //намираме позицията на катерицата
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 's') {
                    //знаем позицията на катерицата, къде точно се намира на кой ред и колона
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
        }

        for (String direction : directions) {
            matrix[squirrelRow][squirrelCol] = '*';//когато катерицата се мести на текущото и място слагаме *
            //обхождаме масива
            if (direction.equals("left")) {
                squirrelCol--;
            } else if (direction.equals("right")) {
                squirrelCol++;

            } else if (direction.equals("up")) {
                squirrelRow--;
            } else if (direction.equals("down")) {
                squirrelRow++;
            }


            if (squirrelRow < 0 || squirrelRow >= size || squirrelCol < 0 || squirrelCol >= size) {
                isTrap=true;
                System.out.println("The squirrel is out of the field.");
                break;

            }

            //проверяваме мястото на което ще отиде катерицата
            if (matrix[squirrelRow][squirrelCol] == 't') {
                isTrap=true;
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            }
            if (matrix[squirrelRow][squirrelCol] == 'h') {
                hazelnuts++;

                if (hazelnuts==3){
                    System.out.println("Good job! You have collected all hazelnuts!");
                    matrix[squirrelRow][squirrelCol]='s';
                    break;

                }

                matrix[squirrelRow][squirrelCol]='*';

            }
        }
        if (hazelnuts>=3 || isTrap){
        System.out.printf("Hazelnuts collected: %d%n",hazelnuts);

    }
        else  {
            System.out.println("There are more hazelnuts to collect.");
            System.out.printf("Hazelnuts collected: %d%n",hazelnuts);
        }

        }




    }
