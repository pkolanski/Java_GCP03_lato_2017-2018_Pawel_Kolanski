package webcrawler.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty loginProperty = new SimpleStringProperty();
    private StringProperty passwordProperty = new SimpleStringProperty();
    private IntegerProperty ageProperty = new SimpleIntegerProperty();
    private StringProperty addressProperty = new SimpleStringProperty();
    private StringProperty sexProperty = new SimpleStringProperty();

    public User(String login, String password, int age, String address, String sex) {
        this.loginProperty.set(login);
        this.passwordProperty.set(password);
        this.ageProperty.set(age);
        this.addressProperty.set(address);
        this.sexProperty.set(sex);
    }

    public StringProperty getLoginProperty() {
        return this.loginProperty;
    }

    public StringProperty getPasswordProperty() {
        return this.passwordProperty;
    }

    public IntegerProperty getAgeProperty() {
        return this.ageProperty;
    }

    public StringProperty getAddressProperty() {
        return this.addressProperty;
    }

    public StringProperty getSexProperty() {
        return this.sexProperty;
    }

    public String getStringLoginProperty() {
        return (String) this.loginProperty.get();
    }

    public String getStringPasswordProperty() {
        return (String) this.passwordProperty.get();
    }

    public void setLoginProperty(StringProperty loginProperty) {
        this.loginProperty = loginProperty;
    }

    public void setPasswordProperty(StringProperty passwordProperty) {
        this.passwordProperty = passwordProperty;
    }

    public void setAgeProperty(IntegerProperty ageProperty) {
        this.ageProperty = ageProperty;
    }

    public void setAddressProperty(StringProperty addressProperty) {
        this.addressProperty = addressProperty;
    }

    public void setSexProperty(StringProperty sexProperty) {
        this.sexProperty = sexProperty;
    }

    public String toString() {
        return (String) this.loginProperty.get() + " " + (String) this.passwordProperty.get();
    }
}
