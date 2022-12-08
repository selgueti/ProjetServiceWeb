package fr.uge.projet.bike;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBike extends Remote, fr.uge.projet.bike.lease.IBike, fr.uge.projet.bike.sell.IBike {
    
    String asString() throws RemoteException;
}
