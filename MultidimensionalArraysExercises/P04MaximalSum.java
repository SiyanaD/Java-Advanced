package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);

        int [][] matrix = new int[row][col];
        filledMatrix(matrix,scanner);

        int maxSum = Integer.MIN_VALUE;//намиране на максималната сума
        int sum = 0;
        int rowIndex = 0;
        int colIndex = 0;


        for (int findRow = 0; findRow <matrix.length-2; findRow++) {
            for (int findCol = 0; findCol <matrix[findRow].length-2; findCol++) {

                sum=matrix[findRow][findCol]+matrix[findRow][findCol+1]+matrix[findRow][findCol+2]+
                        matrix[findRow+1][findCol]+matrix[findRow+1][findCol+1]+matrix[findRow+1][findCol+2]+
                        matrix[findRow+2][findCol]+matrix[findRow+2][findCol+1]+matrix[findRow+2][findCol+2];

//                for (int currentRow = findRow; currentRow <findRow+3 ; currentRow++) {
//                    for (int currentCol = findCol; currentCol <findCol+3 ; currentCol++) {
//                        sum+=matrix[currentRow][currentCol];
//
//                    }
//
//                }

                if (sum>maxSum){
                    maxSum=sum;
                    rowIndex=findRow;
                    colIndex=findCol;

                }
            }
        }
        System.out.printf("Sum = %d%n",maxSum);
        printMatrix(matrix,rowIndex,colIndex);
    }

    private static void printMatrix(int[][] matrix, int rowIndex, int colIndex) {
        for (int row = rowIndex; row <rowIndex+3 ; row++) {
            for (int col = colIndex; col <colIndex+3 ; col++) {
                System.out.print(matrix[row][col]+ " ");

            }
            System.out.println();

        }
    }

    private static void filledMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int cal = 0; cal <matrix[row].length ; cal++) {
                matrix[row][cal]=Integer.parseInt(data[cal]);
            }

        }

    }
}
