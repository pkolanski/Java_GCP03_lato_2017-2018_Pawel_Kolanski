package webcrawler;

public class MonitorException extends Exception {
    public MonitorException()
    {
        System.err.println("Incorrect thread number! ");;
    }
}
