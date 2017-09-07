package webcrawler.RMIServer;


import webcrawler.Models.CrawlerException;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main
{
    static int port=3302;
    static String name="//localhost:"+port+"/RMICrawlerProxy";
    public static void main(String[] args) throws IOException, CrawlerException, InterruptedException, AlreadyBoundException {
        RMICrawlerProxy rmiCrawlerProxy=new RMICrawlerProxy();
        Registry registry= LocateRegistry.createRegistry(port);
        registry.bind(name,rmiCrawlerProxy);
    }
}
