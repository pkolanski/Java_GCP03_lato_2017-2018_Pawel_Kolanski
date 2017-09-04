package webcrawler.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class StudentsObserveList {
    public static ObservableList<StudentProperty> studentList = FXCollections.observableArrayList();
    public static ObservableList<Log> logList = FXCollections.observableArrayList();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public StudentsObserveList() {
    }

    public static void addObservationList(StudentProperty student, String status) {
        Date date = new Date();
        studentList.add(student);
        studentList.sorted();
        Log log = new Log(dateFormat.format(date), status, student.toString());
        logList.add(log);
    }

    public static void removeObservationList(StudentProperty student, String status) {
        Date date = new Date();
        StudentProperty tmp = new StudentProperty(0.0D, "", "", 0);
        Iterator var4 = studentList.iterator();

        while(var4.hasNext()) {
            StudentProperty el = (StudentProperty)var4.next();
            if(el.toString().equals(student.toString())) {
                Log log = new Log(dateFormat.format(date), status, el.toString());
                logList.add(log);
                tmp = el;
                showObservationList();
            }
        }

        studentList.remove(tmp);
    }

    public static void showObservationList() {
        Iterator i = studentList.iterator();

        while(i.hasNext()) {
            StudentProperty el = (StudentProperty)i.next();
            System.out.println(el.toString());
        }

    }
}
