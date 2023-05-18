package MultidimensionalArraysExercises;


import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[]line = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(line[0]);
        int col = Integer.parseInt(line[1]);
        String [][] matrix = new String[row][col];

        fillTheMatrix(matrix,scanner);

        String data = scanner.nextLine();
        while (!data.equals("END")){

            if (isValidMatrix(data,row,col)){
                String [] dataParts = data.split("\\s+");



                //взимам първия елемент
                int row1=Integer.parseInt(dataParts[1]);
                int col1=Integer.parseInt(dataParts[2]);

                //взимам втория елемент
                int row2=Integer.parseInt(dataParts[3]);
                int col2=Integer.parseInt(dataParts[4]);

                String firstElement = matrix[row1][col1];
               String secondElement = matrix[row2][col2];

                //размяна на местата на елементите в матрицата;
                matrix[row1][col1]=secondElement;
                matrix[row2][col2]=firstElement;

                printTheMatrix(matrix);

            }
            else {
                System.out.println("Invalid input!");

            }

            data=scanner.nextLine();
        }



    }

    private static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();

        }
    }

    private static boolean isValidMatrix(String data, int row, int col) {

        String[] commandsPart = data.split("\\s+");

        //валидни части на командата
        if (commandsPart.length!=5){
            return false;
        }

        if (!commandsPart[0].equals("swap")){
            return false;
        }
        //дали редовете и колоните дадени в командата ги има в матрицата
        int row1=Integer.parseInt(commandsPart[1]);
        int col1=Integer.parseInt(commandsPart[2]);
        int row2=Integer.parseInt(commandsPart[3]);
        int col2=Integer.parseInt(commandsPart[4]);

        if (row1<0 || row1>=row || col1<0 || col1>=col || row2<0 || row2>=row || col2<0 || col2>=col){
            return false;
        }
        return true;
    }

    private static void fillTheMatrix(String[][] matrix,Scanner scanner) {//четене на стрингова матрица
        for (int row = 0; row < matrix.length ; row++) {
            matrix[row]=scanner.nextLine().split("\\s");

        }
    }
}
