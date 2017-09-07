package webcrawler.RMIServer;

import webcrawler.Models.Crawler;
import webcrawler.Models.CrawlerException;
import webcrawler.Models.Student;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMICrawlerProxy extends UnicastRemoteObject implements CrawlerMethods {
    private Crawler crawler;
    private LogEvent event;

    public RMICrawlerProxy() throws RemoteException {
        super();
    }
    @Override
    public void start() throws InterruptedException, IOException, CrawlerException {
        crawler=new Crawler();
        crawler.setAddress("students.txt");
        this.crawler.addStudentAddedListener((Student) -> {
            try {
                makeLog("ADDED", Student);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        crawler.addStudentRemovedListener((Student) -> {
            try {
                makeLog("REMOVED", Student);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void setLogEvent(LogEvent event) throws RemoteException {
        this.event=event;
    }

    @Override
    public void sendLogs(String log) throws RemoteException {
        this.event.logSent(log);
    }

    private void makeLog(String status, Student student) throws RemoteException {
        sendLogs(status + ";" + student.getMark() + ";" + student.getFirstName() + ";" + student.getLastName() + ";" + student.getAge());
    }

}