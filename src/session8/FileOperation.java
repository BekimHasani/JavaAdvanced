package session8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOperation {
    private String path;
    public FileOperation(String path) throws FileNotFoundException {
        this.path = path;
    }

    public void copy(String toPath) throws IOException{
        try(FileReader fileReader = new FileReader(path);
            FileWriter fileWriter = new FileWriter(toPath)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.write(ch);
            }
            fileWriter.flush();
        }
    }

    public void copyPrintWriter(String toPath) throws IOException{
        try(FileReader fileReader = new FileReader(path);
            PrintWriter fileWriter = new PrintWriter(new FileWriter(toPath, true))) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileWriter.printf("%c",ch);
            }
            fileWriter.flush();
        }
    }

    public void copyLines(String toPath) throws IOException{
        final List<String> lines = Files.readAllLines(Paths.get(path));
        Files.write(Paths.get(toPath), lines);
    }

    public void readChar() throws IOException  {
        try(FileReader fileReader = new FileReader(path)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.printf("%c", ch);
            }
        }
    }

    public void readLine() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }

    public void readLineNumber() throws IOException {
        try(LineNumberReader br = new LineNumberReader(new FileReader(path))){
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(br.getLineNumber()+":"+line);
            }
        }
    }

    public void readLines() throws IOException{
        final List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line: lines) {
            System.out.println(line);
        }
    }

}
