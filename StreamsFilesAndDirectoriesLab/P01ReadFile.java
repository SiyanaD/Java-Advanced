package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\RENDAVIEW 02\\IdeaProjects\\untitled\\Java Advanced\\src\\04." +
                " Java-Advanced-Streams-Files-and-Directories-Resources\\04." +
                " Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
            FileInputStream fileInputStream = new FileInputStream(path);

            int currentByte = fileInputStream.read();

            while (currentByte>=0){
                //79 -> двоична бройна система ("1001111")
                System.out.print(Integer.toBinaryString(currentByte) + " ");
                currentByte=fileInputStream.read();
            }
            fileInputStream.close();




    }
}
