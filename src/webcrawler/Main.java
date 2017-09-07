package webcrawler;


import webcrawler.Models.*;
import webcrawler.RMIServer.CrawlerMethods;
import webcrawler.RMIServer.LogEvent;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Main
{
    public static void main(String[] args) throws IOException, CrawlerException, InterruptedException, NotBoundException {
        GUIThread thread=new GUIThread();
        (new Thread(thread)).start();
        Registry registry=LocateRegistry.getRegistry("localhost",3302);
        CrawlerMethods crawlerMethods=(CrawlerMethods) registry.lookup("RMICrawlerProxy");

        crawlerMethods.start();
    }
    private class RemoteLogEvent extends UnicastRemoteObject implements LogEvent{

        protected RemoteLogEvent() throws RemoteException {
        }

        @Override
        public void logSent(String log) throws RemoteException {
            String[] logParts = log.split(";");
            String status = logParts[0];
            Student student = new Student();
            student.setMark(Double.parseDouble(logParts[1]));
            student.setFirstName(logParts[2]);
            student.setLastName(logParts[3]);
            student.setAge(Integer.parseInt(logParts[4]));

            GUILogger guiLogger = new GUILogger();
            guiLogger.log(status,student);
        }
    }
}
