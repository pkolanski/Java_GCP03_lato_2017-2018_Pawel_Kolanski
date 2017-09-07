package webcrawler.RMIServer;


import webcrawler.Models.CrawlerException;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CrawlerMethods extends Remote {
    public void start() throws InterruptedException,IOException,CrawlerException,RemoteException;
    public void setLogEvent( LogEvent event ) throws RemoteException;
    public void sendLogs(String txt) throws RemoteException;
}