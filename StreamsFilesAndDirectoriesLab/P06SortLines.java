package StreamsFilesAndDirectoriesLab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04." +
                " Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        Path pathWrite = Paths.get("C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Lab-Resources\\outputWriter.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        Collections.sort(allLines);
        Files.write(pathWrite,allLines);

    }
}
