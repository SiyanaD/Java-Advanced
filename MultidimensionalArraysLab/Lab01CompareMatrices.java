package MultidimensionalArraysLab;

import java.util.Scanner;

public class Lab01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(input[0]);
        int firstColumns = Integer.parseInt(input[1]);

        int[][] firstMatrices =  new int[firstRows][firstColumns];

        for (int i = 0; i <firstRows ; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            for (int j = 0; j <firstColumns ; j++) {

                firstMatrices[i][j]=Integer.parseInt(data[j]);
            }

        }
        input =scanner.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(input[0]);
        int secondColumns = Integer.parseInt(input[1]);

        int[][] secondMatrices = new int[secondRows][secondColumns];

        for (int i = 0; i <secondRows ; i++) {
            String []data = scanner.nextLine().split("\\s+");
            for (int j = 0; j <secondColumns ; j++) {
                secondMatrices[i][j]=Integer.parseInt(data[j]);
            }

        }

        if (firstRows!=secondRows||firstColumns!=secondColumns){
            System.out.println("not equal");
            return;//прекъсва цикъла
        }
        for (int i = 0; i <firstRows ; i++) {
            for (int j = 0; j <firstColumns ; j++) {
                if (firstMatrices[i][j]!=secondMatrices[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");


    }
}
