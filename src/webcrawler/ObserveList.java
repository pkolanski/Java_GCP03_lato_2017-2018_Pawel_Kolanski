package webcrawler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import webcrawler.GUI.CustomBarChart;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObserveList {
    public static ObservableList<StudentProperty> data = FXCollections.observableArrayList();
    public static ObservableList<Log> dataLog = FXCollections.observableArrayList();

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final static Date date = new Date();


    public static void addToObList(StudentProperty student, String status) {
        Log log = new Log(dateFormat.format(date), status, student.toString());
        dataLog.add(log);
        data.add(student);
    }

    public static void removeFromObList(StudentProperty student, String status) {
        for (StudentProperty el : data) {

            if (el.getLastName().equals(student.getLastName())) {
                data.remove(el);
                CustomBarChart.degreeRemove(student);
                Log log = new Log(dateFormat.format(date), status, student.toString());
                dataLog.add(log);

                break;
            }

        }
    }
}
