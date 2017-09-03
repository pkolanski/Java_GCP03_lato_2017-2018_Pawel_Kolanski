package webcrawler.GUI;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import webcrawler.ObserveList;
import webcrawler.StudentProperty;

public class CustomBarChart extends AnchorPane {
    public static int two = 0;
    public static int three= 0;
    public static int threeH= 0;
    public static int four = 0;
    public static int fourH=0;
    public static int five = 0;

    public static BarChart makeBarChart()
    {


        for (StudentProperty el: ObserveList.data)
        {
            degreeAdd(el);
        }

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Mark");


        NumberAxis yAxis = new NumberAxis(0,4,1);
        yAxis.setLabel("Count");


        BarChart<Integer, Integer> barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataseries = new XYChart.Series();
        dataseries.setName("Mark");

        dataseries.getData().add(new XYChart.Data("2.0",two));
        dataseries.getData().add(new XYChart.Data("3.0",three));
        dataseries.getData().add(new XYChart.Data("3.5",threeH));
        dataseries.getData().add(new XYChart.Data("4.0",four));
        dataseries.getData().add(new XYChart.Data("4.5",fourH));
        dataseries.getData().add(new XYChart.Data("5.0",five));


        barChart.getData().add(dataseries);
        barChart.setTitle("Distribution of marks");
        return  barChart;
    }

    public static void degreeAdd(StudentProperty el)
    {
        if (el.getMarkk() == 2.0)
        {
            two++;
        }else if (el.getMarkk() ==3.0)
        {
            three++;
        }else if (el.getMarkk() == 3.5)
        {
            threeH++;
        }else if (el.getMarkk() ==4.0)
        {
            four++;
        }else if (el.getMarkk() ==4.5)
        {
            fourH++;
        }else if (el.getMarkk() == 5.0)
        {
            five++;
        }
    }

    public static void degreeRemove(StudentProperty el)
    {
        if (el.getMarkk() == 2.0)
        {
            two--;
        }else if (el.getMarkk() ==3.0)
        {
            three--;
        }else if (el.getMarkk() == 3.5)
        {
            threeH--;
        }else if (el.getMarkk() ==4.0)
        {
            four--;
        }else if (el.getMarkk() ==4.5)
        {
            fourH--;
        }else if (el.getMarkk() == 5.0)
        {
            five--;
        }
    }
}
