package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            String [] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col <matrix[row].length ; col++) {
                matrix[row][col]=Integer.parseInt(input[col]);
            }
        }
        //намиране на основния диагонал на квадратна матрица [0][0] [1][1] [2][2],  row==column
        for (int i = 0; i <matrix.length ; i++) {
            primaryDiagonal +=matrix[i][i];

        }
        //намиране на 2рия диагонал [3][0] [2][1] [1][2] [0][3],
        for (int row = matrix.length-1,col =0; col <matrix.length ;row--, col++) {
            secondaryDiagonal+=matrix[row][col];
        }
       sum=Math.abs(primaryDiagonal-secondaryDiagonal);//Math.abs - дава модулно число : 4-15= 11,

        System.out.println(sum);






    }
}
