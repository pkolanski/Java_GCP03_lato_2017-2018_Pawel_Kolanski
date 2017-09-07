package webcrawler.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import webcrawler.Models.Encryptor;
import webcrawler.Models.UsersObserveList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        File file =new File("app.config");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Encryptor encryptor=new Encryptor();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file,true);
            fileOutputStream.write(loginField.getText().getBytes());
            fileOutputStream.write(" ".getBytes());
            fileOutputStream.write(encryptor.Encrypt(passwordField.getText()));
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
