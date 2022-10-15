import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.RandomIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class RandomNumberWriter implements RandomIO {
    Random randomNumber;

    public RandomNumberWriter(long seed){
        randomNumber = new Random(seed);
    }

    public void writeRandomChars(String fileName) throws IOException {
        //Step1: get a file ready
        File f = new File(fileName);
        //Step2: set up writer
        FileWriter out = new FileWriter(f);
        //Step3: write
        for (int i = 0; i < 10000; i++) {
            String writeOut = Integer.toString(randomNumber.nextInt(100000)) + "\n";
            out.write(writeOut);
           //out.write("\n");
        }
        //Step4 close the stream
        out.close();
    }

    public void writeRandomByte(String fileName) throws IOException {
        //Step1: get a file ready
        File f = new File(fileName);
        //Step2: set up stream
        FileOutputStream out = new FileOutputStream(f);
        //Step3: start to write
        for(int i=0; i<10000; i++){
            //generate random number
            int number = randomNumber.nextInt(100000);
            //String writeOut = Integer.toString(number);
            byte[] b = ByteBuffer.allocate(4).putInt(number).array();
            out.write(b);
        }
        //Step4: close the stream
        out.close();
    }
}
