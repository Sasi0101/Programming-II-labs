import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.ConcatenateJavaFiles;

import java.io.*;
import java.util.Scanner;
public class JavaFileUtil implements ConcatenateJavaFiles {

    @Override
    public void concatenateJavaFiles(String dirName, String fileName) throws IOException {
        File dir = new File(dirName);
        //creating the file in the directory where we are
        File myFile = new File(dir + File.separator + fileName);
        File[] files;
        //check whether its a directory or not
        if (dir.isDirectory()) {
            files = dir.listFiles(); //listing the files in the directory
            FileWriter writer = new FileWriter(myFile); //making a writer for the specified file
            assert files != null;
            for(File file : files) {
                //open a scanner and write
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    writer.append(str).append("\n");
                    }
                //flushing the writer and closing the scanner
                writer.flush();
                sc.close();
            }
            //closing the writer
            writer.close();
        } else throw new IllegalArgumentException(dirName + "is not a directory");
    }
}
