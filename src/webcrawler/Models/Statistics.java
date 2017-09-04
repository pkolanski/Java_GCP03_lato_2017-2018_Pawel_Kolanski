package webcrawler.Models;

public class Statistics {
    private static int[] statistic = new int[6];

    public Statistics() {
    }

    public void updateStatistic(StudentProperty el, int x) {
        if(el.getMark() == 2.0) {
            statistic[0] += x;
        } else if(el.getMark() == 3.0) {
            statistic[1] += x;
        } else if(el.getMark() == 3.5) {
            statistic[2] += x;
        } else if(el.getMark() == 4.0) {
            statistic[3] += x;
        } else if(el.getMark() == 4.5) {
            statistic[4] += x;
        } else if(el.getMark() == 5.0) {
            statistic[5] += x;
        }

    }

    public int getStatistics(int i) {
        return statistic[i];
    }
}