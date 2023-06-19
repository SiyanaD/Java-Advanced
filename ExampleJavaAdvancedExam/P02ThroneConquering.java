package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int energyParisHas = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char [][] matrix = new char[n][n];

        //пълнене на квадратна char матрица
        for (int row = 0; row <n ; row++) {
            String rowContent = scanner.nextLine();//"--H--"
            char [] symbolRow = rowContent.toCharArray();// toCharArray()->["-" "-" "H" "-" "-"]
            matrix[row] = symbolRow;
        }
        //намираме къде се намира Paris
        //обхождаме цялата матрица
        int rowParis = -1;
        int colParis = -1;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol=='P'){
                    //знаем позицията на Paris, къде точно се намира на кой ред и колона
                    rowParis=row;
                    colParis=col;
                }
            }
        }

    while (true) {

        String[] command = scanner.nextLine().split("\\s+");
        //"{direction} {row have spartan} {col have spartan}".split(" ")
        // -> ["direction", "row", "col"]
        String direction = command[0];
        //Spartan spawns on the given indices.-Spartan се появява на дадените индекси
        int spartanSpawnsRow = Integer.parseInt(command[1]);
        int spartanSpawnsCol = Integer.parseInt(command[2]);

        matrix[rowParis][colParis] = '-';
        matrix[spartanSpawnsRow][spartanSpawnsCol] = 'S';
        //•	Then, Paris moves in a direction, which decreases his energy by 1.
        //o	It can be "up", "down", "left", "right".
        if (direction.equals("up")) {
            if (rowParis - 1 >= 0) {
                rowParis--;
            }
        } else if (direction.equals("down")) {
            if (rowParis + 1 < matrix.length) {
                rowParis++;
            }
        } else if (direction.equals("left")) {
            if (colParis - 1 >= 0) {
                colParis--;
            }

        } else if (direction.equals("right")) {
            if (colParis + 1 < matrix.length) {
                colParis++;
            }
        }
        //o	If Paris tries to move outside of the field, he doesn’t move
        // but still has his energy decreased.
        if (rowParis < 0 || rowParis >= n || colParis < 0 || colParis >= n) {
          break;
        }
        energyParisHas--;

        //2. проверка дали е умрял
        if (energyParisHas <= 0) {
            parisDead(matrix, rowParis, colParis);
            return;//прекратява while (true)

        }

        //•	If an enemy is in the same cell where Paris moves, Paris fights him,
        // which decreases his energy by 2. If
        // Paris’ energy drops at 0 or below,
        // he dies and you should mark his position with ‘X’.
        if (matrix[rowParis][colParis]=='S'){
            energyParisHas-=2;
        if (energyParisHas <= 0) {
            parisDead(matrix, rowParis, colParis);
            return;//прекратява while (true)

        }
        //•	If Paris kills the enemy successfully, the enemy disappears
        else {
            matrix[rowParis][colParis] = '-';
        }
        }

        //•	If Paris reaches the index where Helen is,
        // they both run away (disappear from the field),
        // even if his energy is 0 or below.
        else if (matrix[rowParis][colParis]=='H') {
            matrix[rowParis][colParis]='-';
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n",energyParisHas);
            printMatrix(matrix);
            return;
        }

    }

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
           System.out.println();

        }
    }

    private static void parisDead(char[][] matrix, int rowParis, int colParis) {
        //Парис умира
        //1. там където е бил слагаме X
        matrix[rowParis][colParis] = 'X';
        //2. отпечатване -> къде е умрял
        //•	If Paris is running out of energy, print "Paris died at {row};{col}."
        System.out.printf("Paris died at %d;%d.%n",rowParis,colParis);
        //  //3. отпечатваме матрицата
        printMatrix(matrix);
    }

}

