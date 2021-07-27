package session8;

import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        String path = "D:/test.txt";
        FileOperation fileOperation = null;
        try {
            fileOperation = new FileOperation(path);
//            readFile.readChar();
//            readFile.readLine();
//            readFile.readLineNumber();
//            fileOperation.readLines();
//            fileOperation.copy("D:/test.out");
            fileOperation.copyPrintWriter("D:/test.out");
        }
//        catch (FileNotFoundException fnfe){
//            fnfe.printStackTrace();
//        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
