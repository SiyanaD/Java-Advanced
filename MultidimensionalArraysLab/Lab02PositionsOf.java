package MultidimensionalArraysLab;

import java.util.Scanner;

public class Lab02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        int row=Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        int [][] matrices = new int[row][column];

        for (int i = 0; i <row ; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            for (int j = 0; j <matrices[i].length ; j++) { //matrices[i].length-правилния начин за четене на колона -> column
                matrices[i][j]=Integer.parseInt(data[j]);
            }

        }
        int searchNumber = Integer.parseInt(scanner.nextLine());

       boolean isFound=false;

        for (int i = 0; i < matrices.length; i++) {

            for (int k = 0; k <matrices[i].length ; k++) {

                if (searchNumber==matrices[i][k]){
                    System.out.println(i + " " + k);

                   isFound=true;
                }
            }
        }
     if (!isFound){
            System.out.println("not found");

        }
    }
}
