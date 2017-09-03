package webcrawler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Log {

    private final StringProperty day = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty studentdata = new SimpleStringProperty();

    public Log(String da, String st, String student)
    {
        day.set(da);
        status.set(st);
        studentdata.set(student);
    }
    public StringProperty dayProperty() {return day;}
    public StringProperty statusProperty() {return status;}
    public StringProperty studentdataProperty() {return studentdata;}

    public final String getday() {return day.get();}
    public final String getstatus() {return status.get();}
    public final String getstudentdata() {return studentdata.get();}

    public final void setday(String da){day.set(da);}
    public final void setStatus(String st){status.set(st);}
    public final void setStudentdata(String stda){studentdata.set(stda);}
}
