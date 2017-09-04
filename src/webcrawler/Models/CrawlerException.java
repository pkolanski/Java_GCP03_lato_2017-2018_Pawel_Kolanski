package webcrawler.Models;

/**
 * Created by Paweł on 18.03.2017.
 */
public class CrawlerException extends Exception
{
    public CrawlerException()
    {
        System.out.println("Incorrect address, set the right address");
    }
}
