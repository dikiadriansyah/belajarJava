// package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServer extends Remote {
    int stringToInt(String string) throws RemoteException;
}