package webcrawler.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentProperty {
    private final DoubleProperty mark = new SimpleDoubleProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();

    public StudentProperty(double ma, String fn, String ln, int ag) {
        this.mark.set(ma);
        this.firstName.set(fn);
        this.lastName.set(ln);
        this.age.set(ag);
    }

    public DoubleProperty markProperty() {
        return this.mark;
    }

    public StringProperty firstNameProperty() {
        return this.firstName;
    }

    public StringProperty LastNameProperty() {
        return this.lastName;
    }

    public IntegerProperty ageProperty() {
        return this.age;
    }

    public final double getMark() {
        return this.mark.get();
    }

    public final String getFirstName() {
        return (String)this.firstName.get();
    }

    public final String getLastName() {
        return (String)this.lastName.get();
    }

    public final int getAge() {
        return this.age.get();
    }

    public final void setMark(double m) {
        this.mark.set(m);
    }

    public final void setFirstName(String fn) {
        this.firstName.set(fn);
    }

    public final void setLastName(String ln) {
        this.firstName.set(ln);
    }

    public final void setAge(int a) {
        this.age.set(a);
    }

    public final String toString() {
        return "mark:" + this.getMark() + " name:" + this.getFirstName() + " " + this.getLastName() + " age:" + this.getAge();
    }
}
