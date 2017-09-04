package webcrawler.Models;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Log {
    private final StringProperty day = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty studentdata = new SimpleStringProperty();

    public Log(String da, String st, String student) {
        this.day.set(da);
        this.status.set(st);
        this.studentdata.set(student);
    }

    public StringProperty dayProperty() {
        return this.day;
    }

    public StringProperty statusProperty() {
        return this.status;
    }

    public StringProperty studentdataProperty() {
        return this.studentdata;
    }

    public final String getday() {
        return (String)this.day.get();
    }

    public final String getstatus() {
        return (String)this.status.get();
    }

    public final String getstudentdata() {
        return (String)this.studentdata.get();
    }

    public final void setday(String da) {
        this.day.set(da);
    }

    public final void setStatus(String st) {
        this.status.set(st);
    }

    public final void setStudentdata(String stda) {
        this.studentdata.set(stda);
    }
}
