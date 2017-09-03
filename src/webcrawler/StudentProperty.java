package webcrawler;

import javafx.beans.property.*;

public class StudentProperty {
    private final DoubleProperty mark = new SimpleDoubleProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();

    public StudentProperty(double ma, String fn, String ln, int ag){
        mark.set(ma);
        firstName.set(fn);
        lastName.set(ln);
        age.set(ag);
    }

    public DoubleProperty markProperty() {return  mark;}
    public StringProperty firstNameProperty() {return firstName;}
    public StringProperty getLastNameProperty() {return lastName;}
    public IntegerProperty ageProperty() {return  age;}

    public final double getMarkk () {return mark.get();}
    public final String getFirstName() {return firstName.get();}
    public final String getLastName() {return lastName.get();}
    public final int getAge() {return age.get();}

    public final void setMarkk (double m){mark.set(m);}
    public final void setFirstName(String fn){firstName.set(fn);}
    public final void setLastName(String ln){firstName.set(ln);}
    public final void setAge(int a){age.set(a);}

    public final String toString()
    {
        return ("mark:" + getMarkk() + " name:" + getFirstName() + " " + getLastName() + " age:" + getAge());
    }
}
