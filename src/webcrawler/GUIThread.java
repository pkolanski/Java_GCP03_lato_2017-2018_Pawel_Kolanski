package webcrawler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import webcrawler.GUI.CustomMenuBar;
import webcrawler.GUI.CustomTabPane;

public class GUIThread extends Application implements Runnable{
    @Override
    public void run(){
        launch();
    }
    public void start(Stage primaryStage){

        AnchorPane anchorpane = new AnchorPane();



        MenuBar menuBar = CustomMenuBar.makeMenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        anchorpane.getChildren().add(menuBar);
        AnchorPane.setTopAnchor(menuBar, 0.0);



        TabPane tabPane = CustomTabPane.makeTabPane();
        tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
        tabPane.prefHeightProperty().bind(primaryStage.heightProperty());

        anchorpane.getChildren().add(tabPane);
        AnchorPane.setLeftAnchor(tabPane, 0.0);
        AnchorPane.setTopAnchor(tabPane, 25.0);

        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            KeyCombination kc= new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
            if (kc.match(event)) {
                primaryStage.close();
                System.exit(0);
            }
        });

        Scene scene = new Scene(anchorpane, 410, 420);
        primaryStage.setTitle("Crawler");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
