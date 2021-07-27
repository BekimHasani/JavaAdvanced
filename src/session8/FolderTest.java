package session8;

import java.io.IOException;

public class FolderTest {
    public static void main(String[] args) {
        String path = "D:/test";

        try {
            Folder folder = new Folder(path);
            folder.deleteFiles("baff");
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
