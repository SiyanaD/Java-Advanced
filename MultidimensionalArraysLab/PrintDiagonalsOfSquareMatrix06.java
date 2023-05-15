package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()); //матрицата е квадрат

        int [][] matrix = new int[size][];

        for (int row = 0; row <size ; row++) {

            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(number -> Integer.parseInt(number)).toArray();
            //number->Integer.parseInt(number) == Integer::parseInt

            matrix[row]=currentRow;

        }

        //принтиране  на първия диагонал на квадратна матрица [0][0] [1][1] [2][2],  row==column

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i]+ " ");
            
        }
        System.out.println();

        // принтиране на 2рия диагонал [3][0] [2][1] [1][2] [0][3],

        for (int row = size-1, column = 0; column < size;  row--,column++) {
            System.out.print(matrix[row][column]+ " ");

        }
        System.out.println();


    }
}
