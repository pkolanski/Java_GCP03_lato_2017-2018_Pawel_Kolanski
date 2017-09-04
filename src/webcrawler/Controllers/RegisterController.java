package webcrawler.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import webcrawler.Models.UsersObserveList;

public class RegisterController {

    private  MainController mainController;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField sexField;

    @FXML
    private Label addStatus;

    @FXML
    public void backToLogPanel()
    {
        mainController.loadLogPanel();
    }

    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }

    @FXML
    public void saveUser()
    {
        UsersObserveList tmp = new UsersObserveList();
        UsersObserveList.addUser(loginField.getText(), passwordField.getText(),Integer.parseInt(ageField.getText()), addressField.getText(), sexField.getText());

        clearField();
        addStatus.setText("Success");

    }

    @FXML
    public void clearField()
    {
        loginField.clear();
        passwordField.clear();
        ageField.clear();
        addressField.clear();
        sexField.clear();
        addStatus.setText("");
    }

}
