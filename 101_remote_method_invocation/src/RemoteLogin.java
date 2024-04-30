package callbackRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteLogin extends Remote {
    RemoteConnection login(String name, RemoteClient client) throws RemoteException;
}