package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        String [][] matrix = new String[row][col];

        fillTheMatrix(matrix);
        printTheMatrix(matrix);
    }

    private static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }

    }

    private static void fillTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {

                char outsideLetter = (char) ('a' + row); //кастване в char
                char middleLetter = (char) ('a'+row+col);
                matrix[row][col]= "" + outsideLetter+middleLetter+outsideLetter;//""-с празен стринг - конкатенация, convert in to String

            }

        }

    }
}
