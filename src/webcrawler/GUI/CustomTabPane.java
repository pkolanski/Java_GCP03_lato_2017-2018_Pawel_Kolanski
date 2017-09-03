package webcrawler.GUI;
import javafx.scene.layout.AnchorPane;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import webcrawler.CustomTableViewLog;
import webcrawler.Log;
import webcrawler.StudentProperty;

public class CustomTabPane extends AnchorPane{
    public static TabPane makeTabPane()
    {
        TabPane tabPane = new TabPane();

        Tab students = new Tab("Students");

        TableView<StudentProperty> tableView = CustomTableView.makeTableView();
        students.setContent(tableView);

        Tab logi = new Tab("Log");

        TableView<Log> tableViewLog = CustomTableViewLog.makeTableViewLog();
        logi.setContent(tableViewLog);


        Tab histogram = new Tab("Histogram");

        BarChart barChart = CustomBarChart.makeBarChart();
        histogram.setContent(barChart);

        tabPane.getTabs().addAll(students, logi, histogram);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);



        return  tabPane;
    }


}
