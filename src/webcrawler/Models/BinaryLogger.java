package webcrawler.Models;

import java.io.*;
import java.util.List;

public class BinaryLogger implements Logger, Closeable {
    @Override
    public void close() throws IOException {

    }

    @Override
    public void log(String status, Student student) {
        LoggedStudent loggedStudent=new LoggedStudent(student,System.currentTimeMillis()/1000,status);
        File file=new File("BinaryLog");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            DataOutputStream dataOutputStream=new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(loggedStudent.toString());
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<LoggedStudent>listStudents(){
        File file=new File("BinaryLog");
        if(!file.exists()){
            return null;
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            DataInputStream dataInputStream=new DataInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
