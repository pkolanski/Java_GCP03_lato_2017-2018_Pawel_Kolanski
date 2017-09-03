package webcrawler.GUI;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableView;
import webcrawler.ObserveList;
import webcrawler.StudentProperty;

public class CustomTableView extends AnchorPane {
    public static TableView<StudentProperty> makeTableView(){


        TableColumn<StudentProperty, Double> columnMark = new TableColumn<StudentProperty, Double>("Mark");
        columnMark.setCellValueFactory(new PropertyValueFactory<StudentProperty, Double>("mark"));

        TableColumn<StudentProperty, String> columnFirstName = new TableColumn<StudentProperty, String>("First Name");
        columnFirstName.setCellValueFactory(new PropertyValueFactory<StudentProperty, String>("firstName"));

        TableColumn<StudentProperty, String> columnLastName = new TableColumn<StudentProperty, String>("Last Name");
        columnLastName.setCellValueFactory(new PropertyValueFactory<StudentProperty, String>("lastName"));

        TableColumn<StudentProperty, Integer> columnAge = new TableColumn<StudentProperty, Integer>("Age");
        columnAge.setCellValueFactory(new PropertyValueFactory<StudentProperty, Integer>("age"));

        TableView<StudentProperty> tableView = new TableView<StudentProperty>(ObserveList.data);
        tableView.getColumns().addAll(columnMark, columnFirstName, columnLastName, columnAge);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        return tableView;
    }

}
