package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
String path = "C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04. " +
        "Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(inputStream);



        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int number = scanner.nextInt();
                System.out.println(number);
            }
            scanner.next();

        }
    }
}
