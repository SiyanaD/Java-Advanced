package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        String pathRead = "C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04." +
                " Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String pathWrite = "C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04." +
                " Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\everyThitdLine.txt";

        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream fileOutputStream = new FileOutputStream(pathWrite);

        Scanner reader = new Scanner(inputStream);
        PrintWriter write = new PrintWriter(fileOutputStream);
        int count = 1;
        String line = reader.nextLine();

        while (reader.hasNextLine()){
            if (count%3==0){
                write.println(line);

            }
            count++;
            line=reader.nextLine();

        }
        write.close();
        reader.close();


    }
}
