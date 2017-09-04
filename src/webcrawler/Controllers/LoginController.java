package webcrawler.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import webcrawler.Models.UsersObserveList;

import java.io.IOException;

public class LoginController {
    private MainController mainController;

    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }


    @FXML
    private Label labelMessage;

    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;

    @FXML
    public void signIn() {

        if(UsersObserveList.searchUser(textField.getText(), passwordField.getText()))
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/webcrawler/Views/CrawlerScene.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CrawlerController crawlerController = loader.getController();
            crawlerController.setMainController(mainController);
            mainController.setScene(anchorPane);
        }
        else
        {
            labelMessage.setText("Password incorrect");
        }
    }

    @FXML
    public void signUp()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/webcrawler/Views/RegisterScene.fxml"));
        AnchorPane anchorPane = null;
        try{
            anchorPane = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        RegisterController signUpController = loader.getController();
        signUpController.setMainController(mainController);
        mainController.setScene(anchorPane);
    }

    @FXML
    public  void exit()
    {
        Platform.exit();
    }

}
