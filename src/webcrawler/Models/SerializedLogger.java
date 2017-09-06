package webcrawler.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializedLogger implements Logger, Closeable{
    private static int objectCount=0;
    public SerializedLogger() {

    }

    @Override
    public void log(String status, Student student) {
        LoggedStudent loggedStudent=new LoggedStudent(student,System.currentTimeMillis()/1000,status);

        File file=new File("SerializedLog");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file,true);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(loggedStudent);
            objectCount++;
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<LoggedStudent>listStudents(){
        ArrayList<LoggedStudent> studentsList = new ArrayList<>();
        File file=new File("SerializedLog");
        if(!file.exists()){
            return null;
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            int i=0;
            while(i<objectCount){
                LoggedStudent el=(LoggedStudent)objectInputStream.readObject();
                studentsList.add(el);
            }
            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return studentsList;
    }
    @Override
    public void close() throws IOException {

    }
}
