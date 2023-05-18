package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split(",\\s+");

        int n = Integer.parseInt(line[0]);
        String type = line[1];

        int [][] matrix = new int[n][n];//квадратна матрица row = col

        if (type.equals("A")){
            fillTheMatrix(matrix);

        }
        else if (type.equals("B")) {
            fillTheMatrixB(matrix);



        }
        printMatrix(matrix);

    }

    private static void fillTheMatrixB(int[][] matrix) {

        int counter = 1;

        for (int col = 0; col < matrix.length ; col++) {

            if ((col+1) % 2 !=0 ){ //когато реда не е четен
                for (int row = 0; row < matrix.length ; row++) {

                    matrix[row][col]=counter++;
                }
            }

            else {
                for (int row = matrix.length-1; row >=0; row--) {

                    matrix[row][col]=counter++;

                }
            }

        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix.length ; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }
    }

    private static void fillTheMatrix(int[][] matrix) {

        int counter = 1;

        for (int col = 0; col < matrix.length ; col++) {
            for (int row = 0; row < matrix.length ; row++) {

                matrix[row][col]=counter++;

            }

        }
    }
}
