import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.*;

public class PersonListImplementation extends UnicastRemoteObject
        implements PersonListInterface {
    private static final long serialVersionUID = 1L;

    // standard constructor needs to be available
    public PersonListImplementation() throws RemoteException {
    }

    /**
     * Implementation of "PersonListInterface"
     * 
     * @throws RemoteException
     */
    @Override
    public ArrayList<String> getPersonList() throws RemoteException {
        ArrayList<String> personList = new ArrayList<String>();

        personList.add("Peter Pan");
        personList.add("Pippi Langstrumpf");
        // add your name here :)

        return personList;
    }
}