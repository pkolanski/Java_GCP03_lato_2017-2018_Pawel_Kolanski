package webcrawler.Controllers;
import java.util.Iterator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import webcrawler.Models.Log;
import webcrawler.Models.Statistics;
import webcrawler.Models.StudentProperty;
import webcrawler.Models.StudentsObserveList;

public class CrawlerController {
    private MainController mainController;
    @FXML
    private TableView<StudentProperty> tableView;
    @FXML
    private TableColumn<StudentProperty, Double> markTable;
    @FXML
    private TableColumn<StudentProperty, String> firstNameTable;
    @FXML
    private TableColumn<StudentProperty, String> lastNameTable;
    @FXML
    private TableColumn<StudentProperty, Integer> ageTable;
    @FXML
    private TableView<Log> tableLog;
    @FXML
    private TableColumn<Log, String> timeLog;
    @FXML
    private TableColumn<Log, String> statusLog;
    @FXML
    private TableColumn<Log, String> studentDataLog;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    public static final String[] marksTab = new String[]{"2.0", "3.0", "3.5", "4.0", "4.5", "5.0"};
    public Statistics statistics = new Statistics();

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public CrawlerController() {
    }

    @FXML
    public void closeAction() {
        Platform.exit();
    }

    @FXML
    public void aboutAction() {
        Alert alert = new Alert(AlertType.NONE);
        alert.setTitle("About");
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.setContentText("Autor: Paweł Kolański");
        alert.show();
    }

    @FXML
    private void initialize() {
        this.markTable.setCellValueFactory(new PropertyValueFactory("mark"));
        this.firstNameTable.setCellValueFactory(new PropertyValueFactory("firstName"));
        this.lastNameTable.setCellValueFactory(new PropertyValueFactory("lastName"));
        this.ageTable.setCellValueFactory(new PropertyValueFactory("age"));
        this.tableView.setItems(StudentsObserveList.studentList);
        this.tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.timeLog.setCellValueFactory(new PropertyValueFactory("day"));
        this.statusLog.setCellValueFactory(new PropertyValueFactory("status"));
        this.studentDataLog.setCellValueFactory(new PropertyValueFactory("studentdata"));
        this.tableLog.setItems(StudentsObserveList.logList);
        Series series1 = new Series();
        series1.setName("Marks");
        series1.getData().add(new Data(marksTab[0], Integer.valueOf(0)));
        series1.getData().add(new Data(marksTab[1], Integer.valueOf(0)));
        series1.getData().add(new Data(marksTab[2], Integer.valueOf(0)));
        series1.getData().add(new Data(marksTab[3], Integer.valueOf(0)));
        series1.getData().add(new Data(marksTab[4], Integer.valueOf(0)));
        series1.getData().add(new Data(marksTab[5], Integer.valueOf(0)));
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(1000.0D), (actionEvent) -> {
            Iterator var2 = this.barChart.getData().iterator();

            while (var2.hasNext()) {
                Series series = (Series) var2.next();
                int i = 0;

                for (Iterator var5 = series.getData().iterator(); var5.hasNext(); ++i) {
                    Data data = (Data) var5.next();
                    data.setYValue(Integer.valueOf(this.statistics.getStatistics(i)));
                }
            }

        }, new KeyValue[0]));
        tl.setCycleCount(-1);
        tl.play();
        this.barChart.getData().addAll(new Series[]{series1});
    }
}
