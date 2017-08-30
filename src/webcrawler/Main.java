package webcrawler;


import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, CrawlerException, InterruptedException {
        Crawler crawler=new Crawler();
        crawler.setAddress("students.txt");
        crawler.addIterationStartedListener(iteration -> System.out.println("Iteration " +iteration +" started"));
        crawler.addIterationFinishedListener(iteration -> System.out.println("Iteration "+iteration +" finished"));
        crawler.addStudentAddedListener((status)->{
            for (Logger logger : crawler.loggers) {
                logger.log("ADDED", status);
            }
        });

        crawler.addStudentRemovedListener((status)->{
            for (Logger logger : crawler.loggers) {
                logger.log("REMOVED", status);
            }
        });
        try {
            crawler.run();
        } catch (CrawlerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
