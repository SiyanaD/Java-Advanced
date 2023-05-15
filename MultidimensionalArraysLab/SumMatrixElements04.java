package MultidimensionalArraysLab;

import java.util.Scanner;

public class SumMatrixElements04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] dimension = scanner.nextLine().split(",\\s+");
        int row = Integer.parseInt(dimension[0]);
        int columns = Integer.parseInt(dimension[1]);

        int [][] matrix = new int[row][columns];
        int sum = 0;

        for (int i = 0; i <matrix.length ; i++) {
            String [] input = scanner.nextLine().split(",\\s+");
            for (int j = 0; j <matrix[i].length ; j++) {
                sum+=Integer.parseInt(input[j]);// sum на матрицата


            }

        }
        System.out.println(row);
        System.out.println(columns);
        System.out.println(sum);
    }
}
