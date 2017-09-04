package webcrawler.Models;

import webcrawler.Controllers.CrawlerController;

public class GUILogger implements Logger {
    private CrawlerController crawlerController;

    public GUILogger() {
    }

    public void log(String status, Student student) {
        StudentProperty sp = new StudentProperty(student.getMark(), student.getFirstName(), student.getLastName(), student.getAge());
        Statistics statistics = new Statistics();
        if("ADDED".equals(status)) {
            StudentsObserveList.addObservationList(sp, status);
            statistics.updateStatistic(sp, 1);
        } else if("REMOVED".equals(status)) {
            StudentsObserveList.removeObservationList(sp, status);
            statistics.updateStatistic(sp, -1);
        }
    }
}
