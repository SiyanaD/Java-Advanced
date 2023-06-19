package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String [] numberOfRandC = scanner.nextLine().split(",");
        int nRow = Integer.parseInt(numberOfRandC[0]);
        int mCol = Integer.parseInt(numberOfRandC[1]);

        char[][] matrix = new char[nRow][mCol];
        int eatenCheese = 0;


        for (int row = 0; row <nRow ; row++) {
            String rowContent = scanner.nextLine();
            char [] symbolRow = rowContent.toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = symbolRow[col];
            }
        }
        int mouseRow= -1;
        int mouseCol = -1;

        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol=='M'){
                    mouseRow=row;
                    mouseCol=col;
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("danger")){
            if (input.equals("up")) {
                if (mouseRow-1<0){
                    System.out.println("No more cheese for tonight!");
                    break;
                }
                else {
                    matrix[mouseRow][mouseCol]='*';
                    mouseRow--;
                }
            }

            else if (input.equals("down")) {
                if (mouseRow+1>=nRow){
                    System.out.println("No more cheese for tonight!");
                    break;
                }
                else {
                    matrix[mouseRow][mouseCol]='*';
                    mouseRow++;
                }

            } else if (input.equals("left")) {
                if (mouseCol-1<0){
                    System.out.println("No more cheese for tonight!");
                    break;
                }
                else {
                    matrix[mouseRow][mouseCol]='*';
                    mouseCol--;
                }

            } else if (input.equals("right")) {
                if (mouseCol+1>=mCol){
                    System.out.println("No more cheese for tonight!");
                    break;
                }
                else {
                    matrix[mouseRow][mouseCol]='*';
                    mouseCol++;
                }
            }


            if (matrix[mouseRow][mouseCol]=='C'){
                eatenCheese++;
            }
            if (matrix[mouseRow][mouseCol]=='T'){
                System.out.println("Mouse is trapped!");
                break;
            }
            if(matrix[mouseRow][mouseCol]=='@'){
                continue;
            }


            matrix[mouseRow][mouseCol]='M';
            input=scanner.nextLine();
        }
        printMatrix(matrix);

    }
    private static void printMatrix(char[][] raceRouteMatrix) {
        for (int row = 0; row <raceRouteMatrix.length ; row++) {
            for (int col = 0; col <raceRouteMatrix[row].length ; col++) {
                System.out.print(raceRouteMatrix[row][col]);

            }
            System.out.println();

        }}
}
