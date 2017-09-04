package webcrawler.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainController {

    @FXML
    private Group mainPanel;

    public MainController(){

    }
    @FXML
    public void initialize() {
        this.loadLogPanel();
    }

    public void loadLogPanel()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/webcrawler/Views/LoginScene.fxml"));
        AnchorPane anchorPane = null;
        try{
            anchorPane = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        LoginController logSceneController = loader.getController();
        logSceneController.setMainController(this);
        this.setScene(anchorPane);

    }

    public void setScene(AnchorPane anchorPane)
    {
        mainPanel.getChildren().clear();
        mainPanel.getChildren().add(anchorPane);
    }

}
