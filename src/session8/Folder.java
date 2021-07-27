package session8;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class Folder {

    private File folder;

    public Folder(String path) throws IOException {
        folder = new File(path);
        if(!folder.exists()){
            throw new IOException(String.format("%s does not exist", path));
        }
        if(!folder.isDirectory()){
            throw new IOException(String.format("%s is not a folder", path));
        }
    }

    public void deleteFiles(String word) throws IOException{
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("D:/deleted.txt"))){
            printWriter.printf("Deleted %d files%n",deleteFiles(folder, word));
            printWriter.flush();
        }
    }

    private int deleteFiles(File fld, String word) throws IOException{
        final File[] files = fld.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".txt") || file.isDirectory();
            }
        });
        int count = 0;
        for (File file:files) {
            if(file.isFile()){
                if(processFile(file, word) && file.delete()){
                    count++;
                }
            } else {
                count += deleteFiles(file, word);
            }
        }
        return count;
    }

    private boolean processFile(File file, String word) throws IOException{
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            if(line.toUpperCase().contains(word.toUpperCase())){
                return true;
            }
        }
        return false;
    }


}
