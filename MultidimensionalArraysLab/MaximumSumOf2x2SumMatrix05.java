package MultidimensionalArraysLab;

import java.util.Collections;
import java.util.Scanner;

public class MaximumSumOf2x2SumMatrix05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(",\\s+");



        int row = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int [][] matrix = new int[row][columns];

        int maxSum = 0;
        int maxSumTopLeftRow=-1; // с -1 се използва за сравнение
        int maxSumTopLeftColumn=-1;

        for (int i = 0; i <matrix.length ; i++) {

            String [] data = scanner.nextLine().split(",\\s+");

            for (int j = 0; j <matrix[i].length ; j++) {

                matrix[i][j]=Integer.parseInt(data[j]);

            }
        }

        for (int rowSum = 0; rowSum <matrix.length-1 ; rowSum++) { //matrix.length-1 с колкото добавяме в реда, в случая rowSum+1 с толкова и изваждаме,иначе ще гръмне
            for (int columnSum = 0; columnSum <matrix[rowSum].length-1 ; columnSum++) {  //matrix.length-1 с колкото добавяме в колоната, в случая columnSum+1 с толкова
                                                                                        // и изваждаме,иначе ще гръмне
                int currentSum = matrix[rowSum][columnSum] + matrix[rowSum][columnSum+1]+
                        matrix[rowSum+1][columnSum]+matrix[rowSum+1][columnSum+1];
                if (currentSum>maxSum){

                    maxSum=currentSum;
                    maxSumTopLeftRow=rowSum;//когаро съм намерила нова максимална сума maxSum, maxSumTopLeftRow- приема текущият ред и maxSumTopLeftColumn приема текущата колона
                    maxSumTopLeftColumn=columnSum;
                }


            }

        }
        System.out.println(matrix[maxSumTopLeftRow][maxSumTopLeftColumn] + " " + matrix[maxSumTopLeftRow][maxSumTopLeftColumn+1]);
        System.out.println(matrix[maxSumTopLeftRow+1][maxSumTopLeftColumn]+ " " + matrix[maxSumTopLeftRow+1][maxSumTopLeftColumn+1]);

        System.out.println(maxSum);





    }

}
