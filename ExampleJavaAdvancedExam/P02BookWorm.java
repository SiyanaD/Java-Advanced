package ExampleJavaAdvancedExam;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String startLetter = scanner.nextLine();
        //put startLetter in a StringBuilder
        StringBuilder stringBuilder = new StringBuilder(startLetter);

        int n = Integer.parseInt(scanner.nextLine());
        String [][] matrix = new String[n][n];
        int playerRow=-1;
        int playerCol = -1;

        //пълнене на String матрица квадратна
        for (int row = 0; row <matrix.length ; row++) {
            String [] rowContent = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rowContent[col];
            }
        }
        //. The player will be placed on a random position, marked with "P".
        //намираме "P"
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col <matrix[row].length ; col++) {
                String currentElement = matrix[row][col];
                if (currentElement.equals("P")){
                    playerRow=row;
                    playerCol=col;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")){
            //запазвам от къде тръгвам
            int startRow = playerRow;//ред, от който тръгва
            int startCol = playerCol; //колона, от която тръгва

            //•	Move commands will be: "up", "down", "left", "right".
            boolean isOutside = false;
            if (command.equals("up")){
                playerRow--;
                //проверка дали сме извън матрицата
                if (playerRow<0){
                    //the player’s position is not changed -> playerRow++;
                    playerRow++;
                    isOutside = true;
                }

            }
            else if (command.equals("down")) {
                playerRow++;
                //проверка дали сме извън матрицата
                if (playerRow>=n){
                    //the player’s position is not changed.->playerRow--;
                    playerRow--;
                    isOutside=true;
                }
            }
            else if (command.equals("left")) {
                playerCol--;
                //проверка дали сме извън матрицата
                if (playerCol<0){
                    //the player’s position is not changed.-> playerCol++;
                    playerCol++;
                    isOutside=true;
                }
            }
            else if (command.equals("right")) {
                playerCol++;

                //проверка дали сме извън матрицата
                if (playerCol>=n){
                    //the player’s position is not changed.-> playerCol--;
                    playerCol--;
                    isOutside=true;
                }
            }
            //извършено движение -> вътре или отвън
            //проверка какво има на мястото където е отишъл, само ако не е извън
            if (!isOutside){
                String currentLetter = matrix[playerRow][playerCol];//текстът, който е на мястото, на което отива

                if (!currentLetter.equals("-")){
                    //If he moves to a letter, he consumes it, concatеnates it to the initial string

                    stringBuilder.append(currentLetter);
                }
                matrix[playerRow][playerCol] = "P";//мястото, на което се е преместил
                matrix[startRow][startCol] = "-"; //мястото, от което си тръгнал
            }
            //. If he tries to move outside of the field, he is punished
            // - he loses the last letter in the string, if there are any
            else {
                // the letter disappears from the field
                if (stringBuilder.length() > 0) {//if there are any
                    //премахвам неговата последна буква->stringBuilder.length()-1
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);

                }
            }
            command = scanner.nextLine();
        }
        System.out.println(stringBuilder);
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }
    }
}
