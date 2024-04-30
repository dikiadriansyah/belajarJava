import java.util.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.io.IOException;
import java.rmi.NotBoundException;

public class PersonTest {
    public static void main(String[] args) {
        // get (local) PersonList
        ArrayList<String> personList = PersonListLocal.getInstance().getPersonList();

        // print all persons
        for (String person : personList) {
            System.out.println(person);
        }
    }
}
