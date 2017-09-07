package webcrawler.RMIServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LogEvent extends Remote {
    void logSent(String message) throws RemoteException;
}