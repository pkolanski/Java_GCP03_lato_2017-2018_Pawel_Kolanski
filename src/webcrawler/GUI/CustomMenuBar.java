package webcrawler.GUI;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class CustomMenuBar extends MenuBar {
    public static MenuBar makeMenuBar() {

        MenuBar menuBar = new javafx.scene.control.MenuBar();
        Menu programMenu = new Menu("Program");
        Menu aboutMenu = new Menu();
        Label aboutMenuLabel = new Label("About");
        MenuItem closeMenuItem = new Menu("Close   Ctr+C");

        closeMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        closeMenuItem.setMnemonicParsing(true);
        closeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));

        aboutMenuLabel.setOnMouseClicked(event -> {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("About");
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.setContentText("Autor: Paweł Kolański");
            alert.show();

        });

        aboutMenu.setGraphic(aboutMenuLabel);

        programMenu.getItems().add(closeMenuItem);
        menuBar.getMenus().addAll(programMenu, aboutMenu);


        return menuBar;
    }
}
