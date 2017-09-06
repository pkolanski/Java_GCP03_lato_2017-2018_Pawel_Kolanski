package webcrawler.Models;

import java.io.*;

public class TextLogger implements  Logger ,Closeable{
    public String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public TextLogger(String fileName){
        setFileName(fileName);
    }
    @Override
    public void log(String status, Student student) {
        File file =new File(fileName);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file,true);
            fileOutputStream.write(status.getBytes());
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(student.toString().getBytes());
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {

    }
}