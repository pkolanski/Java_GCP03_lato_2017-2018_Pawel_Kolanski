package webcrawler;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws IOException, CrawlerException, InterruptedException, MonitorException {
        /*final Logger[] loggers= new Logger[]
                {
                  new ConsoleLogger(),
                  //new MailLogger()
                };
        Crawler crawler=new Crawler();
        crawler.setAddress("students.txt");
        crawler.addIterationStartedListener(iteration -> System.out.println("Iteration " +iteration +" started"));
        crawler.addIterationFinishedListener(iteration -> System.out.println("Iteration "+iteration +" finished"));
        crawler.addStudentAddedListener((status)->{
            for (Logger logger : loggers) {
                logger.log("ADDED", status);
            }
        });

        crawler.addStudentRemovedListener((status)->{
            for (Logger logger : loggers) {
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
        }*/
        List<String> listOfFiles = new ArrayList<>();
        listOfFiles.add( "st1.txt" );
        listOfFiles.add( "st2.txt" );
        listOfFiles.add( "st3.txt" );
        listOfFiles.add( "st4.txt" );
        listOfFiles.add( "st5.txt" );
        listOfFiles.add( "st6.txt" );
        listOfFiles.add( "st7.txt" );
        listOfFiles.add( "st8.txt" );
        listOfFiles.add( "st9.txt" );
        listOfFiles.add( "st10.txt" );

        ParallelLogger logger = new ParallelLogger();

        Monitor monitor = new Monitor( listOfFiles, 10 );

        monitor.studentAddedEvent( ( st ) ->
        {
            logger.log( "ADDED", st );
            System.out.println( "" );
        } );

        monitor.studentRemovedEvent( ( st ) ->
        {
            logger.log( "REMOVED", st );
            System.out.println( "" );
        } );

        monitor.run();
        Thread.sleep( 25000 );
        monitor.cancel();
    }
}
