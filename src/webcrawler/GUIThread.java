package webcrawler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GUIThread extends Application implements Runnable {

    public GUIThread(){

    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Group group = FXMLLoader.load(this.getClass().getResource("/webcrawler/Views/MainScene.fxml"));
        Scene scene = new Scene(group);
        primaryStage.setTitle("Crawler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void run() {
        launch();

    }
}
