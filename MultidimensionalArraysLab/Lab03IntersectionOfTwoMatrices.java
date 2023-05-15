package MultidimensionalArraysLab;

import java.util.Scanner;

public class Lab03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int colm = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = fillMatrix(scanner,row,colm);
        char[][] secondMatrix = fillMatrix(scanner,row,colm);

        //принтираме->
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <colm ; j++) {
                if (firstMatrix[i][j]==secondMatrix[i][j]){
                    System.out.print(firstMatrix[i][j]+ " ");
                }
                else {
                    System.out.print("* ");
                }


            }
            System.out.println();

        }



    }
    private static char[][] fillMatrix(Scanner scanner,int rows, int columns){

        char[][] matrix = new char[rows][columns];

        for (int i = 0; i <rows ; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j]=data[j].charAt(0);//charAt(0)->convert in to a char

            }

        }
        return matrix;

    }
}
