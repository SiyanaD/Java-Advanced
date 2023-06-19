package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());//бр.редове = бр.колони

        char [][] matrix = new char[n][n];

        //The mouse will be placed in a random position-правим целочислена променлива за реда и колоната и казваме че са на -1, несъществуващ ред и колона
        int mouseRow= -1;
        int mouseCol = -1;
        int eatenCheese = 0;

        for (int row = 0; row <n ; row++) {   //пълнене на char матрица
            String rowContent = scanner.nextLine();//"M--"
            char [] symbolRow = rowContent.toCharArray();// ["M" "-" "-"]
            matrix[row] = symbolRow;
        }
        //намираме къде точно в матрицата се намира мишката
        //обхождаме цялата матрица
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol=='M'){
                    //знаем позицията на мишката, къде точно се намира на кой ред и колона
                     mouseRow=row;//реда на който се намира мишката е този от който сме взели currentSymbol
                     mouseCol=col;//колоната на който се намира мишката е този от който сме взели currentSymbol
                }
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            matrix[mouseRow][mouseCol] = '-';//когато мишката се мести на текущото и място слагаме -

            if (input.equals("up")) {
                mouseRow--;
            } else if (input.equals("down")) {
                mouseRow++;
            } else if (input.equals("left")) {
                mouseCol--;
            } else if (input.equals("right")) {
                mouseCol++;
            }

            //	If the mouse goes out of its territory - проверяваме дали кооординатите на мишката са валидни
            //преди да поставим мишката проверяваме ред и колона дали съществуват
            if (mouseRow < 0 || mouseRow >= n || mouseCol < 0 || mouseCol >= n) {
                System.out.println("Where is the mouse?");
                break;//прекъсваме цикъла
            }
            //проверяваме мястото на което ще отиде мишката
            if (matrix[mouseRow][mouseCol]=='c'){
                //If the mouse moves to cheese, it eats the cheese and increases the cheese it has eaten by one
                eatenCheese++;
            } else if (matrix[mouseRow][mouseCol]=='B') {
                //If it goes to a bonus, the mouse gets a bonus
                // one move forward and then the bonus disappears
                continue;
            }
            //ако са валидни реда и колоната на мишката слагаме 'M'
            matrix[mouseRow][mouseCol]='M';
            input = scanner.nextLine();
        }
        if (eatenCheese<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-eatenCheese);
        } else  {

            System.out.printf("Great job, the mouse is fed %d cheeses!%n",eatenCheese);
        }

        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }


    }
}
