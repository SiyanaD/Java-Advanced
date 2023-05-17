package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [][] wrongMatrix = fillMatrix(scanner);

        int [][] fixedMatrix = new int[wrongMatrix.length][wrongMatrix[0].length];
        int [] wrongValues = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(s->Integer.parseInt(s)).toArray();

        int wrongNumber = wrongMatrix[wrongValues[0]][wrongValues[1]];
        for (int row = 0; row < wrongMatrix.length; row++) {
            for (int col = 0; col <wrongMatrix[0].length ; col++) {
                int currentNum = wrongMatrix[row][col];

                if (wrongNumber==currentNum){
                    repairingWrongNum(wrongMatrix,fixedMatrix,row,col);
                }
                else {
                    fixedMatrix[row][col]=currentNum;
                }

            }

        }
        for (int row = 0; row < fixedMatrix.length ; row++) {
            for (int col = 0; col <fixedMatrix[row].length ; col++) {
                System.out.print(fixedMatrix[row][col]+ " ");

            }
            System.out.println();

        }


    }

    private static void repairingWrongNum(int[][] wrongMatrix,int [][] fixedMatrix, int row, int col) {
        int newNum = 0;
        int wrongNum = wrongMatrix[row][col];
        if (row-1>=0&&wrongNum!=wrongMatrix[row-1][col]){
            newNum+=wrongMatrix[row-1][col];
        }
        if (row+1<wrongMatrix.length && wrongNum!=wrongMatrix[row+1][col]){
            newNum+=wrongMatrix[row+1][col];

        }
        if (col-1>=0&&wrongNum!=wrongMatrix[row][col-1]){
            newNum+=wrongMatrix[row][col-1];
        }
        if (col+1<wrongMatrix[0].length&&wrongNum!=wrongMatrix[row][col+1]){
            newNum+=wrongMatrix[row][col+1];
        }
        fixedMatrix[row][col]=newNum;


    }

    private static int[][] fillMatrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[rows][];

        for (int i = 0; i <rows ; i++) {

            int [] rowsData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(n->Integer.parseInt(n)).toArray();

            matrix[i]=rowsData;

        }
        return matrix;
    }
}
