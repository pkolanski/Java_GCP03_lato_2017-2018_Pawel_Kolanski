package webcrawler;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomTableViewLog {

    public static TableView<Log> makeTableViewLog() {


        TableColumn<Log, String> columnDay = new TableColumn<>("Time");
        columnDay.setCellValueFactory(new PropertyValueFactory<>("day"));

        TableColumn<Log, String> columnStatus = new TableColumn<>("Status");
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Log, String> columnSD = new TableColumn<>("Student data");
        columnSD.setCellValueFactory(new PropertyValueFactory<>("studentdata"));


        TableView<Log> tableViewLog = new TableView<>(ObserveList.dataLog);
        tableViewLog.getColumns().addAll(columnDay, columnStatus, columnSD);
        tableViewLog.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        columnDay.prefWidthProperty().bind(tableViewLog.widthProperty().multiply(0.28));
        columnStatus.prefWidthProperty().bind(tableViewLog.widthProperty().multiply(0.15));
        columnSD.prefWidthProperty().bind(tableViewLog.widthProperty().multiply(0.57));

        return tableViewLog;
    }
}
